package com.etiya.customerservice.controllers;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.services.abstracts.CityService;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customerservice/api/v1/cities")
@AllArgsConstructor
public class CitiesController {
    private CityService cityService;


    @GetMapping("/getAll")
    public GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo){
        return cityService.getAll(pageInfo);
    }

    @GetMapping("{id}")
    public GetCityResponse getById(@PathVariable long id){
        return cityService.getById(id);
    }

    @PostMapping
    public CreatedCityResponse add(@Valid @RequestBody CreateCityRequest createCityRequest){
        return cityService.add(createCityRequest);
    }

    @PutMapping
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest){
        return cityService.update(updateCityRequest);
    }

    @DeleteMapping("{id}")
    public DeletedCityResponse delete(@PathVariable long id){
        return cityService.delete(id);
    }
}
