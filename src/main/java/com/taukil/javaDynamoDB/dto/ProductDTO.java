package com.taukil.javaDynamoDB.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {

    @NotEmpty(message = "Product ID cannot be empty")
    private String productId;

    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    @NotNull(message = "Price cannot be null")
    private double price;

    @NotEmpty(message = "Description cannot be empty")
    private String description;


}