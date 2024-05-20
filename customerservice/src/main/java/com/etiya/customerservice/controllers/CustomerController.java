package com.etiya.customerservice.controllers;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.CustomerService;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerservice/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/getAll")
    public GetListResponse<GetAllCustomerResponse> getAll(PageInfo pageInfo){
        return customerService.getAll(pageInfo);
    }

    @GetMapping("{id}")
    public GetCustomerResponse getById(@PathVariable String id){
        return customerService.getById(id);
    }


    @DeleteMapping("{id}")
    public DeletedCustomerResponse delete(@PathVariable String id){
        return customerService.delete(id);
    }

}
