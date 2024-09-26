package com.example.ticketting.service;


import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.CustomerInputDto;


public interface CustomerService {

    Customer addNewCustomer(CustomerInputDto customerInputDto);

}
