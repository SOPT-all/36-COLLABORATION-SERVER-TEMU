package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Setter
public class ProductDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productDetailId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private String imageUrl;
}
