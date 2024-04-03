package com.etiya.customerservice.services.rules;


import com.etiya.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.repositories.CityRepository;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityBusinessRules {
    private CityRepository cityRepository;

    public void cityNameCanNotBeDuplicatedWhenInserted(String name){
        Optional<City> city = cityRepository.findByNameIgnoreCase(name);

        if(city.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.CITY_NAME_EXIST);
        }
    }
}
