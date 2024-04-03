package com.etiya.customerservice.services.mappers;

import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    GetAllCityResponse getAllCityResponseFromCity(City city);

    GetCityResponse getCityResponseFromCity(City city);
    City cityFromCreateCityRequest(CreateCityRequest createCityRequest);
    CreatedCityResponse createdCityResponseFromCity(City city);
    UpdatedCityResponse updatedCityResponseFromCity(City city);
    City cityFromUpdateCityRequest(UpdateCityRequest updateCityRequest);

    DeletedCityResponse deletedCityResponseFromCity(City city);
}
