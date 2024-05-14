package com.etiya.customerservice.services.abstracts;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;

public interface CityService {
    GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo);

    GetCityResponse getById(String id);

    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update (UpdateCityRequest updateCityRequest);

    DeletedCityResponse delete(String id);


}
