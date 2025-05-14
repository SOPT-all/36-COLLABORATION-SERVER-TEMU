package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.MainResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.MainResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductDetailResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.ProductReviewResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.SearchResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response.PromotionResponse;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service.ProductService;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.annotation.CustomExceptionDescription;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger.SwaggerResponseDescription.PRODUCT_DETAIL;
import static org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.config.swagger.SwaggerResponseDescription.PRODUCT_REVIEW;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Tag(name="메인페이지 조회 관련 API")
    @Operation(summary = "메인페이지 조회", description = "메인페이지의 정보들을 조회합니다.")
    @GetMapping
    public BaseResponse<MainResponse> getMain() {
        return BaseResponse.ok(productService.getAllProduct());
    }

    @Operation(summary = "특가 상품 조회", description = "특가 상품 5개를 조회합니다.")
    @GetMapping("/promotion")
    public BaseResponse<PromotionResponse> getPromotion(){
        return BaseResponse.ok(productService.getPromotion());
    }

    @Tag(name="검색 관련 API")
    @Operation(summary = "상품 검색", description = "키워드로 상품을 조회합니다.")
    @GetMapping("/search")
    public BaseResponse<SearchResponse> getSearchedProduct(@RequestParam String keyword){
        return BaseResponse.ok(productService.getSearchedProduct(keyword));
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
