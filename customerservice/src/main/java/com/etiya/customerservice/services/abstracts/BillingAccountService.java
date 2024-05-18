package com.etiya.customerservice.services.abstracts;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.services.dtos.requests.billingAccount.UpdateBillingAccountRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.services.dtos.requests.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.services.dtos.responses.billingAccount.*;
import com.etiya.customerservice.services.dtos.responses.contactMedium.CreatedContactMediumResponse;
import com.etiya.customerservice.services.dtos.responses.contactMedium.DeletedContactMediumResponse;
import com.etiya.customerservice.services.dtos.responses.contactMedium.GetContactMediumResponse;
import com.etiya.customerservice.services.dtos.responses.contactMedium.UpdatedContactMediumResponse;

public interface BillingAccountService {
    GetListResponse<GetAllBillingAccountResponse>getAll(PageInfo pageInfo);
    GetBillingAccountResponse getById(String id);
    CreatedBillingAccountResponse add(CreateBillingAccountRequest createBillingAccountRequest);
    UpdatedBillingAccountResponse update(UpdateBillingAccountRequest updateBillingAccountRequest);
    DeletedBillingAccountResponse delete(String id);
}
