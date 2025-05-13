package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductDetailResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductReviewResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.PromotionResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.annotation.CustomExceptionDescription;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger.SwaggerResponseDescription;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger.SwaggerResponseDescription.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Tag(name="특가상품 조회 API")
    @Operation(summary = "특가 상품 조회", description = "특가 상품 5개를 조회합니다.")
    @GetMapping("/promotion")
    public BaseResponse<PromotionResponse> getPromotion(){
        return BaseResponse.ok(productService.getPromotion());
    }

    @CustomExceptionDescription(PRODUCT_DETAIL)
    @Tag(name = "상품 상세 조회 관련 API")
    @Operation(summary = "제품 상세 조회", description = "제품의 상세 정보를 조회합니다.")
    @GetMapping("/{productId}")
    public BaseResponse<ProductDetailResponse> getProductDetail(@PathVariable Long productId) {
        return BaseResponse.ok(productService.getProductDetail(productId));
    }

    @CustomExceptionDescription(PRODUCT_REVIEW)
    @Tag(name = "상품 상세 조회 관련 API")
    @Operation(summary = "제품 리뷰 조회", description = "제품에 달린 리뷰들을 조회합니다.")
    @GetMapping("/{productId}/reviews")
    public BaseResponse<ProductReviewResponse> getProductReview(@PathVariable Long productId) {
        return BaseResponse.ok(productService.getProductReview(productId));
    }
}
