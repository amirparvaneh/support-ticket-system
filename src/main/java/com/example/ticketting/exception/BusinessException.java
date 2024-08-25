package com.example.ticketting.exception;


import com.example.ticketting.global.ErrorResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BusinessException extends RuntimeException{
    private ErrorResponse errorResponse;

    public BusinessException(ErrorResponse errorResponse) {
        super(errorResponse.getMessage());
        this.errorResponse = errorResponse;
    }
}
