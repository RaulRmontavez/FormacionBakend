package com.raul.block7crudvalidation.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {
    private Date timestamp;
    private String mensaje;
    private int HttpCode;

    public CustomError(int HttpCode, String mensaje){
        this.timestamp = new Date();
        this.HttpCode = HttpCode;
        this.mensaje = mensaje;
    }


}