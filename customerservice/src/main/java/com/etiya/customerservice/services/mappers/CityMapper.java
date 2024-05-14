package com.etiya.customerservice.services.mappers;

import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
    @Mapping(source = "city.content",target = "items")
    GetListResponse<GetAllCityResponse> getAllCityResponseFromCity(Page<City> city);


    GetCityResponse getCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
    UpdatedCityResponse updatedCityResponseFromCity(City city);
    City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest);

    DeletedCityResponse deletedCityResponseFromCity(City city);
}
