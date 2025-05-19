package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
//여기서 force=true 안들어가면 에러뜨는데 왜지
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor
@Getter
@Builder
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    @JsonIgnore
    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }
}
