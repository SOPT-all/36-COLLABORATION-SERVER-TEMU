package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {
    @Query("SELECT d.imageUrl FROM ProductDetail d WHERE d.product.id = :productId")
    List<String> findAllProductDetailsByProductId(Long productId);
}
