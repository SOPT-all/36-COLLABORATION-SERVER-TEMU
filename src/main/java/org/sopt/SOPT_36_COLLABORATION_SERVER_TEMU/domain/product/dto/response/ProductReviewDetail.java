package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProductReviewDetail(
        @Schema(description = "리뷰 ID", example = "1") Long reviewId,
        @Schema(description = "사용자 닉네임", example = "dlwjddus1112") String nickname,
        @Schema(description = "별점", example = "5") int score,
        @Schema(description = "리뷰 사진", example = "image") String imageUrl,
        @Schema(description = "리뷰 내용", example = "맛있어요~") String content,
        @Schema(description = "상품 옵션(더미 데이터)", example = "갈색") String productOption,
        @Schema(description = "리뷰 생성일", example = "2022-02-02") String createdAt
) {
}
