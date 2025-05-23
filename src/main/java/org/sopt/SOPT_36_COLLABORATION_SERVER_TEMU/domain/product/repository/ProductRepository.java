package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDiscountRateGreaterThan(int rate);

    @Query("select p from Product p where p.productName like concat('%', :keyword, '%') ")
    List<Product> findByProductNameContaining(String keyword);
}
