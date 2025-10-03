package com.springboot.jpa.service.impl;

import com.springboot.jpa.data.dao.ProductDao;
import com.springboot.jpa.data.dto.ProductDto;
import com.springboot.jpa.data.dto.ProductResponseDto;
import com.springboot.jpa.data.entity.Product;
import com.springboot.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDao.selectProduct(number);

        return ProductResponseDto.builder()
            .number(product.getNumber())
            .name(product.getName())
            .price(product.getPrice())
            .stock(product.getPrice())
            .build();
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = Product.of(productDto);

        Product savedProduct = productDao.insertProduct(product);

        return ProductResponseDto.builder()
            .number(savedProduct.getNumber())
            .name(savedProduct.getName())
            .price(savedProduct.getPrice())
            .stock(savedProduct.getPrice())
            .build();
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productDao.updateProductName(number, name);

        return ProductResponseDto.builder()
            .number(changeProduct.getNumber())
            .name(changeProduct.getName())
            .price(changeProduct.getPrice())
            .stock(changeProduct.getStock())
            .build();
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDao.deleteProduct(number);
    }
}
