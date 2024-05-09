package com.etiya.customerservice.controllers;


import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.ContactMediumService;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/contactMediums")
@AllArgsConstructor
@CrossOrigin
public class ContactMediumController {
    private ContactMediumService contactMediumService;

    @GetMapping("/getAll")
    public GetListResponse<GetAllContactMediumResponse> getAll(PageInfo pageInfo){
        return contactMediumService.getAll(pageInfo);
    }

    @GetMapping("/{id}")
    public GetContactMediumResponse getById(@PathVariable String id){
        return contactMediumService.getById(id);
    }

    @PostMapping
    public CreatedContactMediumResponse add(@Valid @RequestBody CreateContactMediumRequest createContactMediumRequest){
        return contactMediumService.add(createContactMediumRequest);
    }

    @PutMapping
    public UpdatedContactMediumResponse update(@Valid @RequestBody UpdateContactMediumRequest updateContactMediumRequest){
        return contactMediumService.update(updateContactMediumRequest);
    }

    @DeleteMapping("{id}")
    public DeletedContactMediumResponse delete(@PathVariable String id){
        return contactMediumService.delete(id);
    }
}
