package com.etiya.customerservice.services.concretes;


import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.entities.ContactMedium;
import com.etiya.customerservice.repositories.ContactMediumRepository;
import com.etiya.customerservice.services.abstracts.ContactMediumService;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;
import com.etiya.customerservice.services.mappers.ContactMediumMapper;
import com.etiya.customerservice.services.rules.ContactMediumBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {
    private ContactMediumRepository contactMediumRepository;
    private ContactMediumBusinessRules contactMediumBusinessRules;

    @Override
    public GetListResponse<GetAllContactMediumResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<ContactMedium> response = contactMediumRepository.findAll(pageable);

        List<ContactMedium> filteredContactMediums = response.getContent()
                .stream()
                .filter(contactMedium -> contactMedium.getDeletedDate() == null)
                .collect(Collectors.toList());
        Page<ContactMedium> filteredResponse = new PageImpl<>(filteredContactMediums, pageable, response.getTotalElements());

        GetListResponse<GetAllContactMediumResponse> contactMediumResponse = ContactMediumMapper.INSTANCE.getAllContactMediumResponseFromContactMedium(filteredResponse);
        contactMediumResponse.setHasNext(filteredResponse.hasNext());
        contactMediumResponse.setHasPrevious(filteredResponse.hasPrevious());
        return contactMediumResponse;
    }

    @Override
    public GetContactMediumResponse getById(long id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        return ContactMediumMapper.INSTANCE.getContactMediumResponseFromContactMedium(contactMedium);
    }

    @Override
    public CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest) {
        contactMediumBusinessRules.EmailCanNotBeDuplicatedWhenInserted(createContactMediumRequest.getEmail());
        ContactMedium contactMedium = ContactMediumMapper.INSTANCE.contactMediumFromCreateContactMediumRequest(createContactMediumRequest);
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
    public DeletedContactMediumResponse delete(long id) {
        ContactMedium contactMedium = contactMediumRepository.findById(id).get();
        contactMedium.setDeletedDate(LocalDateTime.now());
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.deletedContactMediumResponseFromContactMedium(contactMedium);
    }
}
