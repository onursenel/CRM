package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import com.etiya.customerservice.services.dtos.responses.city.GetAllCityResponse;

import java.util.List;

public interface AddressService {
    GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo);
    GetAddressResponse getById(String id);
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);
    DeletedAddressResponse delete(String id);
}
