package com.example.ticketting.mapper;


import com.example.ticketting.model.Customer;
import com.example.ticketting.model.dto.CustomerInputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerInputDtoToEntity(CustomerInputDto customerInputDto);
}
