package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record PromotionProductInfo(
    @Schema(description = "제품 ID", example = "1") Long productId,
    @Schema(description = "제품명", example = "무조립 접이식, 어쩌구 저쩌구,.,,") String productName,
    @Schema(description = "할인율", example = "50") int discountRate,
    @Schema(description = "할인가", example = "9900") int discountPrice,
    @Schema(description = "제품 이미지") String productImage
){
}
