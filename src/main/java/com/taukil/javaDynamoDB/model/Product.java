package com.taukil.javaDynamoDB.model;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String name;
    private double price;
    private String description;

}
