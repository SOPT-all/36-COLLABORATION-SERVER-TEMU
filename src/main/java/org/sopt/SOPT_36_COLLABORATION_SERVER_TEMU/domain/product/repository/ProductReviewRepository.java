package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.ProductReview;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
    @Query("SELECT COUNT(r) FROM ProductReview r WHERE r.product.id = :productId")
    int getReviewCountByProductId(Long productId);

    @Query("SELECT AVG(r.score) FROM ProductReview r WHERE r.product.id = :productId")
    Double getAverageScoreByProductId(Long productId);

    @Query("SELECT r.user FROM ProductReview r WHERE r.product.id = :productId AND r.id = :reviewId")
    User findUserByProductIdAndReviewId(Long productId, Long reviewId);

    List<ProductReview> findAllByProductId(Long productId);

    @Query("SELECT r.score, COUNT(r) FROM ProductReview r WHERE r.product.id = :productId GROUP BY r.score")
    List<Object[]> countReviewGroupByScore(Long productId);

    int countByProduct_Id(Long productId);
}
