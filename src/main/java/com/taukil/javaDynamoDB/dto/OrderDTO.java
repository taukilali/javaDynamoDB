package com.taukil.javaDynamoDB.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class OrderDTO {

    @NotEmpty(message = "User ID cannot be empty")
    private String userId;

    @NotEmpty(message = "Product ID cannot be empty")
    private String productId;

    @Positive(message = "Quantity must be greater than zero")
    private int quantity;

}
