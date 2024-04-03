package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;

import java.util.List;

public interface CustomerService {

    GetCustomerResponse getById(long id);
    List<GetAllCustomerResponse> getAll();
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);
    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);
    DeletedCustomerResponse delete(long id);
}
