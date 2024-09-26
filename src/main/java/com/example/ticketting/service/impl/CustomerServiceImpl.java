package com.example.ticketting.service.impl;

import com.example.ticketting.exception.CustomerException;
import com.example.ticketting.mapper.CustomerMapper;
import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.CustomerInputDto;
import com.example.ticketting.repository.CustomerRepository;
import com.example.ticketting.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer addNewCustomer(CustomerInputDto customerInputDto) {
        Customer customer = CustomerMapper.INSTANCE.customerInputDtoToEntity(customerInputDto);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerByCode(String code) {
        return customerRepository.findCustomerByCode(code).orElseThrow(()-> new CustomerException(code));
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(String code) {
        Optional<Customer> customerByCode = customerRepository.findCustomerByCode(code);
        if (Objects.isNull(customerByCode)){
            throw new CustomerException(code);
        }else {
            customerRepository.delete(customerByCode.get());
        }
    }
}
