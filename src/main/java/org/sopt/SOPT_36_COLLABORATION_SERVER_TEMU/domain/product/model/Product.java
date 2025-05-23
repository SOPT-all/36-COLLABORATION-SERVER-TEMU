package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.global.enums.ProductTag;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;

    @Column(nullable = false)
    private String productName;

    private int originalPrice;

    private int discountRate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ProductTag tag;

    @Column(nullable = false)
    private String company;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductColor> productColors = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductDetail> productDetails = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<ProductReview> productReviews = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCategory> productCategories = new ArrayList<>();

    // 연관관계 편의 메서드들
    public void addProductColor(ProductColor color) {
        productColors.add(color);
        color.setProduct(this);
    }

    public void addProductDetail(ProductDetail detail) {
        productDetails.add(detail);
        detail.setProduct(this);
    }

    public void addProductImage(ProductImage image) {
        productImages.add(image);
        image.setProduct(this);
    }

    public void addProductReview(ProductReview review) {
        productReviews.add(review);
        review.setProduct(this);
    }

    public void addProductCategory(ProductCategory category) {
        productCategories.add(category);
        category.setProduct(this);
    }

    @PrePersist
    private void ensureRecommendCategory() {
        boolean hasRecommend = productCategories.stream()
                .anyMatch(pc -> pc.getCategoryName() == Category.RECOMMEND);
        if (!hasRecommend) {
            ProductCategory recommend = ProductCategory.builder()
                    .categoryName(Category.RECOMMEND)
                    .product(this)
                    .build();
            productCategories.add(recommend);
        }
    }
}