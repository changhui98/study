package com.springboot.jpa.data.entity;

import com.springboot.jpa.data.dto.ProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public static Product of(ProductDto productDto) {
        Product product = new Product();
        product.name = productDto.getName();
        product.price = productDto.getPrice();
        product.stock = productDto.getStock();
        product.createAt = LocalDateTime.now();
        product.updateAt = LocalDateTime.now();

        return product;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeUpdateAt(LocalDateTime newUpdateTime) {
        this.updateAt = newUpdateTime;
    }

}