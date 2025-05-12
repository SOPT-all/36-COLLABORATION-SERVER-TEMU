package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductDetailResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Product;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.CustomException;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.exception.ErrorCode;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response.BaseResponse;
import org.springframework.stereotype.Service;

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
}
