package com.springboot.jpa.data.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    private String name;
    private int price;
    private int stock;

    public ProductDto(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

}
