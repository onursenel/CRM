package com.etiya.customerservice.services.abstracts;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;

public interface IndividualCustomerService {
    GetIndividualCustomerResponse getById(String id);
    GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo);
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception;
    UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);
    DeletedIndividualCustomerResponse delete(String id);

    public Boolean checkIfNationalIdentityExists(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception;

}
