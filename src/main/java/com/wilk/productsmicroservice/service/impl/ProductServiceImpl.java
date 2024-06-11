package com.wilk.productsmicroservice.service.impl;

import com.wilk.productsmicroservice.model.CreateProductRestModel;
import com.wilk.productsmicroservice.service.ProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {
        return "";
    }
}
