package com.etiya.customerservice.services.mappers;

import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    GetAllCustomerResponse getAllCustomerResponseFromCity(Customer customer);


    GetCustomerResponse getCustomerResponseFromCity(Customer customer);


    Customer customerFromCreateCustomerRequest(CreateCustomerRequest createCustomerRequest);
    CreatedCustomerResponse createdCustomerResponseFromCity(Customer customer);
    UpdatedCustomerResponse updatedCustomerResponseFromCity(Customer customer);
    Customer customerFromUpdateCustomerRequest(UpdateCustomerRequest customerRequest);

    DeletedCustomerResponse deletedCustomerResponseFromCustomer(Customer customer);

}
