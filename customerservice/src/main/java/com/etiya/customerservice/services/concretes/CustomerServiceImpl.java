package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.services.abstracts.CustomerService;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;
import com.etiya.customerservice.services.rules.CustomerBusinessRules;
import com.etiya.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerBusinessRules customerBusinessRules;
    private CustomerRepository customerRepository;
    @Override
    public GetCustomerResponse getById(long id) {
        /*
        Customer customer = customerRepository.findById(id).orElseThrow();//id db'de yoksa hata atıyor
        GetCustomerResponse customerResponse = modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
        return customerResponse;
        */

        /*customerBusinessRules.checkByCustomerId(id);
        GetCustomerResponse customerResponse = modelMapperService.forResponse()
                .map(customerBusinessRules.checkByCustomerId(id), GetCustomerResponse.class);
        return customerResponse;*/



        return null;
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        return null;
    }

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        return null;
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        return null;
    }

    @Override
    public DeletedCustomerResponse delete(long id) {
        return null;
    }
}
