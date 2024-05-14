package com.etiya.customerservice.services.abstracts;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.contactMedium.*;

public interface ContactMediumService {
    GetListResponse<GetAllContactMediumResponse> getAll(PageInfo pageInfo);
    GetContactMediumResponse getById(String id);
    CreatedContactMediumResponse add(CreateContactMediumRequest createContactMediumRequest);
    UpdatedContactMediumResponse update(UpdateContactMediumRequest updateContactMediumRequest);
    DeletedContactMediumResponse delete(String id);
}
