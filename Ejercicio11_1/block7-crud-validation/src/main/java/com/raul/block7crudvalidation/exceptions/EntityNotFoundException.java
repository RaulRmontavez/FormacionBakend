package com.raul.block7crudvalidation.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
@Data
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private final CustomError customError;
    public EntityNotFoundException(String message, int httpCode) {
        super(message);
        this.customError = new CustomError(httpCode,message);
    }

    public CustomError getCustomError(){
        return customError;
    }



}
