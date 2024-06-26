package com.etiya.customerservice.controllers;


import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/individualCustomers")
@AllArgsConstructor
@CrossOrigin()
public class IndividualCustomersController {
    private IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo){
        return individualCustomerService.getAll(pageInfo);
    }
    @GetMapping("{id}")
    public GetIndividualCustomerResponse getById(@PathVariable String id){
        return individualCustomerService.getById(id);
    }

    @PostMapping
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @PutMapping
    public UpdatedIndividualCustomerResponse update(@Valid @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest){
        return individualCustomerService.update(updateIndividualCustomerRequest);
    }

    @DeleteMapping("{id}")
    public DeletedIndividualCustomerResponse delete(@PathVariable String id){
        return individualCustomerService.delete(id);
    }

    @PostMapping("/nationality-identity/check")
    @ResponseStatus(HttpStatus.OK)
    public Boolean checkNationalIdentityExists(@RequestBody CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception {
        return individualCustomerService.checkIfNationalIdentityExists(checkNationalityIdentityRequest);
    }
}
