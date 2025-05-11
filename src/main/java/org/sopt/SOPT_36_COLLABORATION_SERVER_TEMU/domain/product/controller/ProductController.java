package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.controller;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
}
