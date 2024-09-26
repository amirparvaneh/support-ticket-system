package com.example.ticketting.controller;


import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.BaseResponseDTO;
import com.example.ticketting.model.dto.CustomerInputDto;
import com.example.ticketting.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<BaseResponseDTO> addNewCustomer(@RequestBody CustomerInputDto customerInputDto) {
        Customer newCustomer = customerService.addNewCustomer(customerInputDto);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponseDTO.builder()
                .message("customer have been created")
                .result(newCustomer).build());
    }
}
