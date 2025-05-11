package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ProductReviewResponse(
        @Schema(description = "평균 별점", example = "4.5") double avgScore,
        @Schema(description = "이미지가 있는 리뷰들의 이미지들") List<String> reviewImages,
        List<ProductReviewDetail> productReviewDetails,
        List<ReviewScoreDistribution> reviewScoreDistributions
)
{ }
