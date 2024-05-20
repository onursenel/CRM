package com.etiya.customerservice.services.abstracts;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.customer.*;

public interface CustomerService {

    GetCustomerResponse getById(String id);
    GetListResponse<GetAllCustomerResponse> getAll(PageInfo pageInfo);
    DeletedCustomerResponse delete(String id);
}
