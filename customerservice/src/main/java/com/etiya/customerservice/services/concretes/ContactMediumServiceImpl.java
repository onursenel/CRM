package com.etiya.customerservice.services.concretes;


import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.ContactMedium;
import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.repositories.ContactMediumRepository;
import com.etiya.customerservice.services.abstracts.ContactMediumService;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;
import com.etiya.customerservice.services.mappers.ContactMediumMapper;
import com.etiya.customerservice.services.rules.ContactMediumBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private ContactMediumBusinessRules contactMediumBusinessRules;

    @Override
    public GetListResponse<GetAllContactMediumResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<ContactMedium> response = contactMediumRepository.findAll(pageable);

        GetListResponse<GetAllContactMediumResponse> contactMediumResponse = ContactMediumMapper.INSTANCE.getAllContactMediumResponseFromContactMedium(response);
        contactMediumResponse.setHasNext(response.hasNext());
        contactMediumResponse.setHasPrevious(response.hasPrevious());
        return contactMediumResponse;
    }

    @Override
    public GetContactMediumResponse getById(String id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        return ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        contactMediumBusinessRules.EmailCanNotBeDuplicatedWhenInserted(createContactMediumRequest.getEmail());
        contactMediumBusinessRules.checkByCustomerId(createContactMediumRequest.getCustomerId());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
        Customer customer = new Customer();
        customer.setId(createContactMediumRequest.getCustomerId());
        ContactMedium createdContactMedium = contactMediumRepository.save(contactMedium);

        CreatedContactMediumResponse createdContactMediumResponse = ContactMediumMapper.INSTANCE.createdContactMediumResponseFromContactMedium(createdContactMedium);
        return createdContactMediumResponse;
    }

    @Override
    public UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest) {
        contactMediumBusinessRules.EmailCanNotBeDuplicatedWhenInserted(updateContactMediumRequest.getEmail());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromUpdateContactMediumRequest(updateContactMediumRequest);
        ContactMedium updatedContactMedium = contactMediumRepository.save(contactMedium);

        UpdatedContactMediumResponse updatedContactMediumResponse = ContactMediumMapper.INSTANCE.updatedContactMediumResponseFromContactMedium(updatedContactMedium);
        return updatedContactMediumResponse;
    }

    @Override
    public DeletedContactMediumResponse delete(String id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        contactMedium.setDeletedDate(LocalDateTime.now());
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(contactMedium);
    }
}
