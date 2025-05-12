package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.enums.ProductTag;

public record ProductMainInfo(
        @Schema(description = "제품 ID", example = "1") Long productId,
        @Schema(description = "제품명", example = "무조립 접이식, 어쩌구 저쩌구,.,,") String productName,
        @Schema(description = "할인율", example = "50") int discountRate,
        @Schema(description = "할인가", example = "9900") int discountPrice,
        @Schema(description = "제품 이미지") String productImage,
        @Schema(description = "리뷰 수", example = "21") int reviewCount,
        @Schema(description = "제품 태그", example = "재구매 고객이 많은 스토어", allowableValues = {"HIGH_REPURCHASE", "LOW_RETURN", "ESTABLISHED_YEAR_AGO", "NONE"}) ProductTag productTag
        ) {
}
