package com.wilk.productsmicroservice.service.impl;

import com.wilk.productsmicroservice.model.CreateProductRestModel;
import com.wilk.productsmicroservice.service.ProductCreatedEvent;
import com.wilk.productsmicroservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public String createProduct(CreateProductRestModel productRestModel) throws Exception {
        String productID = UUID.randomUUID().toString();
        //TODO: Persist Product Details into DB before publishing an Event
        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
                .productId(productID)
                .title(productRestModel.getTitle())
                .price(productRestModel.getPrice())
                .quantity(productRestModel.getQuantity())
                .build();

        //************Below is code for asynchronously
        /*
        CompletableFuture<SendResult<String,ProductCreatedEvent>> future = kafkaTemplate.send("product-created-events-topic",productID,productCreatedEvent);
        future.whenComplete((result,exception) -> {
            if(exception!= null){
                LOGGER.error("*******Failed to send message: {}",exception.getMessage());
            }else {
               LOGGER.info("*******Message sent successfully: {}",result.getProducerRecord());
            }
        });
        */

        //***********below is code for synchronously

        LOGGER.info("Before publishing a ProductCreatedEvent ");

        SendResult<String, ProductCreatedEvent> result = kafkaTemplate.send("product-created-events-topic", productID, productCreatedEvent).get();

        LOGGER.info("Partition: {}",result.getRecordMetadata().partition());
        LOGGER.info("Topic name: {}",result.getRecordMetadata().topic());
        LOGGER.info("Offset: {}",result.getRecordMetadata().offset());
        LOGGER.info("*******Returning product id");


        return productID;
    }
}
