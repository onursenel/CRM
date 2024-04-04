package com.etiya.customerservice.controllers;


import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/individualCustomers")
@AllArgsConstructor
public class IndividualCustomersController {
    private IndividualCustomerService individualCustomerService;


    @GetMapping("/getAll")
    public GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo){
        return individualCustomerService.getAll(pageInfo);
    }
    @GetMapping("{id}")
    public GetIndividualCustomerResponse getById(@PathVariable long id){
        return individualCustomerService.getById(id);
    }

    @PostMapping
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest){
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @PutMapping
    public UpdatedIndividualCustomerResponse update(@Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest){
        return individualCustomerService.update(updateIndividualCustomerRequest);
    }

    @DeleteMapping("{id}")
    public DeletedIndividualCustomerResponse delete(@PathVariable long id){
        return individualCustomerService.delete(id);
    }
}
