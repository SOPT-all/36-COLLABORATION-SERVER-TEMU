package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record SearchResponse(
        @Schema(description = "검색상품 리스트", example = "") List<SearchedProductInfo> searchedProductList) {
}
