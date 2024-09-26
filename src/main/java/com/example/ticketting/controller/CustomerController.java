package com.example.ticketting.controller;


import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.BaseResponseDTO;
import com.example.ticketting.model.dto.CustomerInputDto;
import com.example.ticketting.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping(value = "/{code}")
    public ResponseEntity<BaseResponseDTO> findCustomerCode(@PathVariable(value = "code") String code){
        customerService.findCustomerByCode(code);

    }


    @GetMapping(value = "/all")
    public ResponseEntity<BaseResponseDTO> getAllCustomer() {
        List<Customer> allCustomer = customerService.findAllCustomer();
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponseDTO
                .builder()
                .message("the whole data")
                .result(allCustomer)
                .build());
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<BaseResponseDTO> deleteCustomer(@PathVariable String code) {
        customerService.deleteCustomer(code);
        return ResponseEntity.status(HttpStatus.OK).body(BaseResponseDTO.builder()
                .message("customer have been deleted with code " + code).build());
    }
}
