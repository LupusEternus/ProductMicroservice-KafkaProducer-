package com.wilk.productsmicroservice.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class CreateProductRestModel {

    private String title;
    private BigDecimal price;
    private Integer quantity;


}
