package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Category;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.ProductCategory;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.model.Product;
import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired private ProductRepository productRepository;
    @Test
    public void createProductTest(){
        //given
        Product product = Product.builder()
                .productName("가방")
//                .category(Category.GOODS)
                .productDetails(null)
                .productImages(null)
                .productReviews(null)
                .build();
        productRepository.save(product);

        //when
        Product findProduct = productRepository.findById(3L).get();
        //then
        Assertions.assertThat(findProduct.getProductName()).isEqualTo("가방");
    }
}
