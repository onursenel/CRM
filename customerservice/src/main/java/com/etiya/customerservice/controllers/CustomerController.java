package com.etiya.customerservice.controllers;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.services.abstracts.CustomerService;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerservice/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<GetAllCustomerResponse> getAll(PageInfo pageInfo){
        return customerService.getAll(pageInfo);
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable long id){
        return customerService.getById(id);
    }

    @PostMapping
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.add(createCustomerRequest);
    }

    @PutMapping
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.update(updateCustomerRequest);
    }

    @DeleteMapping("{id}")
    public DeletedCustomerResponse delete(@PathVariable long id){
        return customerService.delete(id);
    }

}
