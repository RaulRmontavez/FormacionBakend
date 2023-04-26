package com.raul.block7crudvalidation.exceptions;

import java.time.LocalDateTime;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException(String message) {
        super(message);
    }
}