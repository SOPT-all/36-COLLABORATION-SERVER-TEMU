package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    @Query("SELECT i.imageUrl FROM ProductImage i WHERE i.product.id = :productId")
    List<String> findAllImagesByProductId(Long productId);

    ProductImage findFirstByProduct_Id(Long productId);
}
