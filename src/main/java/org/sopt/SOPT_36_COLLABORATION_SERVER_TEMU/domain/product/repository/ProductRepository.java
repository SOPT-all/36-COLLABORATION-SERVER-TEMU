package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
