package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.service;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
}
