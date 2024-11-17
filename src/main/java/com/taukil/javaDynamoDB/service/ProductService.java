package com.taukil.javaDynamoDB.service;

import com.taukil.javaDynamoDB.dto.ProductDTO;
import com.taukil.javaDynamoDB.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;

@Service
public class ProductService {

    private final DynamoDbClient dynamoDbClient;

    private static final String PRODUCTS_TABLE = "Products";

    @Autowired
    public ProductService(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(PRODUCTS_TABLE)
                .item(Map.of(
                        "productId", AttributeValue.builder().s(product.getProductId()).build(),
                        "name", AttributeValue.builder().s(product.getName()).build(),
                        "price", AttributeValue.builder().n(String.valueOf(product.getPrice())).build(),
                        "description", AttributeValue.builder().s(product.getDescription()).build()))
                .build();

        dynamoDbClient.putItem(request);
        return product;
    }

    public Product getProductById(String productId) {
        Product product = new Product();
        GetItemRequest request = GetItemRequest.builder()
                .tableName(PRODUCTS_TABLE)
                .key(Map.of("productId", AttributeValue.builder().s(productId).build()))
                .build();

        GetItemResponse response = dynamoDbClient.getItem(request);
        if (response.hasItem()) {
            Map<String, AttributeValue> item = response.item();
            product.setProductId(item.get("productId").s());
            product.setName(item.get("name").s());
            product.setPrice(Double.parseDouble(item.get("price").n()));
            product.setDescription(item.get("description").s());
            return product;
        }
        return product;
    }
}

