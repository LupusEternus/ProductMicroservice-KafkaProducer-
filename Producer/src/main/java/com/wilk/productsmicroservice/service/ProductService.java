package com.wilk.productsmicroservice.service;

import com.wilk.productsmicroservice.model.CreateProductRestModel;

public interface ProductService {

    String createProduct(CreateProductRestModel productRestModel) throws Exception;
}
