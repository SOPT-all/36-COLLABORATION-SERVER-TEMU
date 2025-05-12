package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Setter
public class ProductReview {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productReviewId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int score;

    @CreatedDate
    @Column(nullable = false)
    private String createdAt;

    private String imageUrl;

    @Column(nullable = false)
    private String purchaseOption;
}
