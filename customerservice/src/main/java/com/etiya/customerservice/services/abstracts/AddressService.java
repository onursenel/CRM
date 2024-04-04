package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;

import java.util.List;

public interface AddressService {
    List<GetAllAddressResponse> getAll(PageInfo pageInfo);
    GetAddressResponse getById(long id);
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);
    DeletedAddressResponse delete(long id);
}
