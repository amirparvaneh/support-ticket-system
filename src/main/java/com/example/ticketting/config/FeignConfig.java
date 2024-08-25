package com.example.ticketting.config;


import feign.Request;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.ticketting.feign")
public class FeignConfig {

    @Bean
    public Request.Options feignOptions() {
        int connectTimeoutMillis = 5; // Connection timeout in milliseconds
        int readTimeoutMillis = 10;   // Read timeout in milliseconds
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }
}
