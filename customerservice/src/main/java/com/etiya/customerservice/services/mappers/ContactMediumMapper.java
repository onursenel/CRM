package com.etiya.customerservice.services.mappers;


import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.ContactMedium;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE = Mappers.getMapper(ContactMediumMapper.class);

    @Mapping(source = "contactMedium.content",target = "items")
    GetListResponse<GetAllContactMediumResponse> getAllContactMediumResponseFromContactMedium(Page<ContactMedium> contactMedium);

    GetContactMediumResponse getContactMediumResponseFromContactMedium(ContactMedium contactMedium);


    ContactMedium contactMediumFromCreateContactMediumRequest(CreateContactMediumRequest createContactMediumRequest);
    CreatedContactMediumResponse createdContactMediumResponseFromContactMedium(ContactMedium contactMedium);


    ContactMedium contactMediumFromUpdateContactMediumRequest(UpdateContactMediumRequest updateContactMediumRequest);
    UpdatedContactMediumResponse updatedContactMediumResponseFromContactMedium(ContactMedium contactMedium);


    DeletedContactMediumResponse deletedContactMediumResponseFromContactMedium(ContactMedium contactMedium);
}
