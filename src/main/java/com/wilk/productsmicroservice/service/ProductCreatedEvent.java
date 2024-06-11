package com.wilk.productsmicroservice.service;


import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor //used in serialization
@Builder
@Getter
@Setter
public class ProductCreatedEvent {

    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
