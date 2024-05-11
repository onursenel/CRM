package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.city.GetAllCityResponse;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;

import java.util.List;

public interface IndividualCustomerService {
    GetIndividualCustomerResponse getById(String id);
    GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo);
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception;
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    DeletedIndividualCustomerResponse delete(String id);
}
