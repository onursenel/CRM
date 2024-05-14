package com.etiya.customerservice.services.concretes;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.services.abstracts.CustomerService;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;
import com.etiya.customerservice.services.mappers.CustomerMapper;
import com.etiya.customerservice.services.rules.CustomerBusinessRules;
import com.etiya.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerBusinessRules customerBusinessRules;
    private CustomerRepository customerRepository;
    @Override
    public GetCustomerResponse getById(String id) {
        customerBusinessRules.customerNotFound(id);
        Customer customer = customerRepository.findById(id).get();
        return CustomerMapper.INSTANCE.getCustomerResponseFromCity(customer);
    }


    @Override
    public GetListResponse<GetAllCustomerResponse> getAll(PageInfo pageInfo){
        Pageable pageable = PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<Customer> response = customerRepository.findAll(pageable);



        GetListResponse<GetAllCustomerResponse> customerResponse = CustomerMapper.INSTANCE.getAllCustomerResponseFromCustomer(response);
        customerResponse.setHasNext(response.hasNext());
        customerResponse.setHasPrevious(response.hasPrevious());
        return customerResponse;
    }

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        customerBusinessRules.customerEmailCanNotBeDuplicatedWhenInserted(createCustomerRequest.getEmail());
        Customer customer = CustomerMapper.INSTANCE.customerFromCreateCustomerRequest(createCustomerRequest);
        Customer createdCustomer = customerRepository.save(customer);

        CreatedCustomerResponse createdCustomerResponse = CustomerMapper.INSTANCE.createdCustomerResponseFromCity(createdCustomer);

        return  createdCustomerResponse;
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        customerBusinessRules.customerEmailCanNotBeDuplicatedWhenInserted(updateCustomerRequest.getEmail());
        customerBusinessRules.customerNotFound(updateCustomerRequest.getId());
        Customer customer = CustomerMapper.INSTANCE.customerFromUpdateCustomerRequest(updateCustomerRequest);
        Customer updatedCustomer = customerRepository.save(customer);

        UpdatedCustomerResponse updatedCustomerResponse = CustomerMapper.INSTANCE.updatedCustomerResponseFromCity(updatedCustomer);

        return  updatedCustomerResponse;
    }

    @Override
    public DeletedCustomerResponse delete(String id) {
        customerBusinessRules.deleteCustomer(id);
        Customer customer = customerRepository.findById(id).get();
        customer.setDeletedDate(LocalDateTime.now());
        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.deletedCustomerResponseFromCustomer(customer);
    }
}
