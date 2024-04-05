package com.etiya.customerservice.services.rules;


import com.etiya.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.IndividualCustomer;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;
    public void individualCustomerNationalityIdCanNotBeDuplicatedWhenInserted(String nationalityId){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdIgnoreCase(nationalityId);

        if(individualCustomer.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.NATIONALITY_ID_EXIST);
        }
    }
}
