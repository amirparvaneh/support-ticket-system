package com.example.ticketting.service;


import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.CustomerInputDto;

import java.util.List;


public interface CustomerService {

    Customer addNewCustomer(CustomerInputDto customerInputDto);

    Customer findCustomerByCode(String code);

    List<Customer> findAllCustomer();

    void deleteCustomer(String code);
}
