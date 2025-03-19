package com.example.demo.service.impl;

import com.example.demo.model.ProductEntity;
import com.example.demo.repo.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(String name) {
        ProductEntity product= new ProductEntity().setName(name).setCompositName(name);
        productRepository.save(product);

    }
}
