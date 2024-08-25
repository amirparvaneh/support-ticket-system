package com.example.ticketting.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Inquiry" , url = "http://localhost:8080" ,path = "/inquiry")
public interface InquiryFeign {
    @GetMapping(value = "/test")
    void callExternal();
}
