package com.example.ticketting.service.impl;

import com.example.ticketting.mapper.CustomerMapper;
import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.CustomerInputDto;
import com.example.ticketting.repository.CustomerRepository;
import com.example.ticketting.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer addNewCustomer(CustomerInputDto customerInputDto) {
        Customer customer = CustomerMapper.INSTANCE.customerInputDtoToEntity(customerInputDto);
        return customerRepository.save(customer);
    }
}
