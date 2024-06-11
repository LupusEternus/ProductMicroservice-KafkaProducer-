package com.wilk.productsmicroservice.controller.rest;


import com.wilk.productsmicroservice.model.CreateProductRestModel;
import com.wilk.productsmicroservice.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductServiceImpl productService;


    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductRestModel product){
        String productID = productService.createProduct(product);
        return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

}
