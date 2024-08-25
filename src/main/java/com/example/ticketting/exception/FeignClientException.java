package com.example.ticketting.exception;

import com.example.ticketting.global.ErrorResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class FeignClientException extends BusinessException{

    public FeignClientException() {
        super(new ErrorResponse(
                "not.valid.connection",
                HttpStatus.NOT_MODIFIED,
                LocalDateTime.now()
        ));
    }
}
