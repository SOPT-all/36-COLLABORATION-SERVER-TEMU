package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductDetailResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductReviewDetail;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductReviewResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ReviewScoreDistribution;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Product;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.ProductReview;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.user.model.User;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.CustomException;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.ErrorCode;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductColorRepository productColorRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductReviewRepository productReviewRepository;

    public ProductDetailResponse getProductDetail(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        return new ProductDetailResponse(
                product.getCompany(),
                product.getProductName(),
                product.getDiscountRate(),
                (int) (product.getOriginalPrice() * (1 - product.getDiscountRate() / 100.0)),  // 할인된 금액
                productImageRepository.findAllImagesByProductId(productId),
                productColorRepository.findAllColorsByProductId(productId),
                productDetailRepository.findAllProductDetailsByProductId(productId),
                productReviewRepository.getReviewCountByProductId(productId),
                productId
        );
    }

    public ProductReviewResponse getProductReview(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new CustomException(PRODUCT_NOT_FOUND));
        List<ProductReview> reviews = productReviewRepository.findAllByProductId(productId);
        List<ProductReviewDetail> productReviewDetails = new ArrayList<>();
        List<String> reviewImages = new ArrayList<>();
        for (ProductReview review : reviews) {
            User user = productReviewRepository.findUserByProductIdAndReviewId(productId, review.getId());
            productReviewDetails.add(new ProductReviewDetail(
                    user.getNickname(),
                    review.getScore(),
                    review.getImageUrl(),
                    review.getContent(),
                    review.getPurchaseOption(),
                    review.getCreatedAt()
            ));
            if(!review.getImageUrl().isEmpty()) {
                reviewImages.add(review.getImageUrl());
            }
        }
        List<Object[]> scoreCountList = productReviewRepository.countReviewGroupByScore(productId);
        int totalReviewCount = reviews.size();

        Map<Integer, Integer> scoreCountMap = new HashMap<>();
        for (Object[] row : scoreCountList) {
            int score = ((Number) row[0]).intValue();
            int count = ((Number) row[1]).intValue();
            scoreCountMap.put(score, count);
        }

        List<ReviewScoreDistribution> scoreDistributions = new ArrayList<>();
        for (int score = 5; score >= 1; score--) {
            int count = scoreCountMap.getOrDefault(score, 0);
            int percentage = totalReviewCount == 0 ? 0 : (int) Math.round((count * 100.0) / totalReviewCount);
            scoreDistributions.add(new ReviewScoreDistribution(score, count, percentage));
        }

        return new ProductReviewResponse(
                productReviewRepository.getAverageScoreByProductId(productId),
                reviewImages,
                productReviewDetails,
                scoreDistributions
        );
    }
}
