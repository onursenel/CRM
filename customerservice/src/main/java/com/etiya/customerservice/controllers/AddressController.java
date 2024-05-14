package com.etiya.customerservice.controllers;


import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.AddressService;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/addresses")
@AllArgsConstructor
@CrossOrigin
public class AddressController {
    private AddressService addressService;

    @GetMapping("/getAll")
    public GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo){
        return addressService.getAll(pageInfo);
    }

    @GetMapping("/{id}")
    public GetAddressResponse getById(@PathVariable String id){
        return addressService.getById(id);
    }

    @PostMapping
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest){
        return addressService.add(createAddressRequest);
    }

    @PutMapping
    public UpdatedAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest){
        return addressService.update(updateAddressRequest);
    }

    @DeleteMapping("{id}")
    public DeletedAddressResponse delete(@PathVariable String id){
        return addressService.delete(id);
    }
}
