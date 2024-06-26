package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.responses.productResponses.CreatedProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedProductResponse add(){
        return productService.add();
    }
}
