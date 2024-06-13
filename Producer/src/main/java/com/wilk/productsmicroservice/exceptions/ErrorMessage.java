package com.wilk.productsmicroservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {

    private String message;
    private LocalDateTime timestamp;
    private String details;
}
