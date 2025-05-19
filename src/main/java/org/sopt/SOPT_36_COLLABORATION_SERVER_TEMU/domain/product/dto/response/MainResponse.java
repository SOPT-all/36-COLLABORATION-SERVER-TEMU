package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record MainResponse(
//        @Schema(description = "카테고리 목록") List<String> category,
        @Schema(description = "전체상품 리스트", example = "") List<ProductMainInfo> productMainInfos) {
}
