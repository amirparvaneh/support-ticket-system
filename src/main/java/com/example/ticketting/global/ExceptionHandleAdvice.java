package com.example.ticketting.global;


import com.example.ticketting.exception.BusinessException;
import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

@RestControllerAdvice
@Slf4j
public class ExceptionHandleAdvice extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ExceptionHandleAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> businessExceptionHandler(BusinessException exception) {
        log.info("an exception has occurred : {}", (exception.getErrorResponse().getMessage() + LocalDateTime.now()));
        exception.getErrorResponse().setMessage(messageSource.getMessage(exception.getErrorResponse().getMessage(),
                exception.getErrorResponse().getParams(), Locale.getDefault()));
        return new ResponseEntity<>(exception.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<String> handleFeignTimeoutException(RetryableException ex) {
        // Log the exception
        logger.error("Connection timeout occurred: " + ex.getMessage());

        // Return 503 Service Unavailable
        return new ResponseEntity<>("Service unavailable due to timeout", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
