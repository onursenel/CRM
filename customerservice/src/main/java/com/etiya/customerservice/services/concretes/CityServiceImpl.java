package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.core.business.paging.BasePagingModel;
import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.repositories.CityRepository;
import com.etiya.customerservice.services.abstracts.CityService;
import com.etiya.customerservice.services.dtos.requests.city.CreateCityRequest;
import com.etiya.customerservice.services.dtos.requests.city.UpdateCityRequest;
import com.etiya.customerservice.services.dtos.responses.city.*;
import com.etiya.customerservice.services.mappers.CityMapper;
import com.etiya.customerservice.services.rules.CityBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CityBusinessRules cityBusinessRules;

    @Override
    public GetListResponse<GetAllCityResponse> getAll(PageInfo pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());// Sayfalama bilgilerini kullanarak bir Pageable nesnesi oluşturuyoruz
        Page<City> response = cityRepository.findAll(pageable);// cityRepository üzerinden findAll metodunu kullanarak veritabanından tüm şehirleri çekiyoruz


        GetListResponse<GetAllCityResponse> cityResponse = CityMapper.INSTANCE.getAllCityResponseFromCity(response); // Filtrelenmiş Page nesnesini GetAllCityResponse nesnelerine dönüştürmek için CityMapper kullanarak bir GetListResponse nesnesi oluşturuyoruz

        cityResponse.setHasNext(response.hasNext());// cityResponse nesnesinin hasNext özelliğini, filtrelendikten sonra kalan veriler için doğru şekilde ayarlıyoruz
        cityResponse.setHasPrevious(response.hasPrevious());   // cityResponse nesnesinin hasPrevious özelliğini, filtrelendikten sonra kalan veriler için geçerli olan hasPrevious özelliği ile eşliyoruz
        return cityResponse; // Son olarak, filtrelenmiş ve dönüştürülmüş verileri içeren cityResponse nesnesini döndürüyoruz
    }




    @Override
    public GetCityResponse getById(String id) {
        City city = cityRepository.findById(id).get();//filter gerekli olur mu?  sor
        return CityMapper.INSTANCE.getCityResponseFromCity(city);
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(createCityRequest.getName());
        City city = CityMapper.INSTANCE.cityFromCreateCityRequest(createCityRequest);
        City createdCity = cityRepository.save(city);

        CreatedCityResponse createdCityResponse = CityMapper.INSTANCE.createdCityResponseFromCity(createdCity);

        return  createdCityResponse;
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest) {
        cityBusinessRules.cityNameCanNotBeDuplicatedWhenInserted(updateCityRequest.getName());
        City city = CityMapper.INSTANCE.cityFromUpdateCityRequest(updateCityRequest);
        City updatedCity = cityRepository.save(city);

        UpdatedCityResponse updatedCityResponse = CityMapper.INSTANCE.updatedCityResponseFromCity(updatedCity);

        return  updatedCityResponse;
    }

    @Override
    public DeletedCityResponse delete(String id) {

        City city = cityRepository.findById(id).get();
        city.setDeletedDate(LocalDateTime.now());
        cityRepository.save(city);
        return CityMapper.INSTANCE.deletedCityResponseFromCity(city);
    }
}
