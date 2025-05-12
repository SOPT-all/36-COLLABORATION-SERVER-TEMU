package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ProductDetailResponse(
        @Schema(description = "회사명", example = "스마일마켓") String company,
        @Schema(description = "제품명", example = "무조립 접이식, 어쩌구 저쩌구,.,,") String productName,
        @Schema(description = "할인율", example = "50") int discountRate,
        @Schema(description = "원가", example = "19800") int originalPrice,
        @Schema(description = "할인가", example = "9900") int discountPrice,
        @Schema(description = "제품 이미지들") List<String> productImages,
        @Schema(description = "제품 색상 리스트") List<String> productColors,
        @Schema(description = "제품 상세 이미지") List<String> productDetails,
        @Schema(description = "리뷰 수", example = "21") int reviewCount,
        @Schema(description = "제품 ID", example = "1") Long productId
        ) {
}
