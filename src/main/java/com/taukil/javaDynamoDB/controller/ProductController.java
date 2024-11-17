package com.taukil.javaDynamoDB.controller;

import com.taukil.javaDynamoDB.dto.ProductDTO;
import com.taukil.javaDynamoDB.model.Product;
import com.taukil.javaDynamoDB.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return Optional.ofNullable(productService.getProductById(productId))
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

