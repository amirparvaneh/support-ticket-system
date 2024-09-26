package com.example.ticketting.exception;


import com.example.ticketting.global.ErrorResponse;
import org.springframework.http.HttpStatus;

public class CustomerException extends BusinessException {

    public CustomerException(String code) {
        super(new ErrorResponse("notFound", HttpStatus.NOT_FOUND, code));
    }
}
