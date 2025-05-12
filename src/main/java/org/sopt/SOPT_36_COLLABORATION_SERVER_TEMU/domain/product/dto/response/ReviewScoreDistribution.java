package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ReviewScoreDistribution (
        @Schema(description = "별점", example = "5") int score,
        @Schema(description = "해당 점수 리뷰 수", example = "10") int reviewCount,
        @Schema(description = "비율", example = "67") int percentage
)
{}
