package com.wilk.productsmicroservice.controller.rest;


import com.wilk.productsmicroservice.exceptions.ErrorMessage;
import com.wilk.productsmicroservice.model.CreateProductRestModel;
import com.wilk.productsmicroservice.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductServiceImpl productService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody CreateProductRestModel product) {
        String productID;
        try {
            productID = productService.createProduct(product);
        } catch (Exception e) {
               LOGGER.error(e.getMessage(),e);
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                       .body(new ErrorMessage(e.getMessage(),LocalDateTime.now(),"/products"));
        }
        return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

}
