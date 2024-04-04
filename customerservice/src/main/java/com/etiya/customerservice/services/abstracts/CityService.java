package com.etiya.customerservice.services.abstracts;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;

import java.util.List;

public interface CityService {

    GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo);

    GetCityResponse getById(long id);

    CreatedCityResponse add(CreateCityRequest createCityRequest);

    UpdatedCityResponse update (UpdateCityRequest updateCityRequest);

    DeletedCityResponse delete(long id);


}
