package com.example.ticketting.feign;

import com.example.ticketting.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Inquiry" , url = "http://localhost:8081" ,path = "/doctors",configuration = FeignConfig.class)
public interface InquiryFeign {
    @GetMapping(value = "/all")
    void callExternal();
}
