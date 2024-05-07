package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;

public interface ContactMediumService {
    GetListResponse<GetAllContactMediumResponse> getAll(PageInfo pageInfo);
    GetContactMediumResponse getById(long id);
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest);
    DeletedContactMediumResponse delete(long id);
}
