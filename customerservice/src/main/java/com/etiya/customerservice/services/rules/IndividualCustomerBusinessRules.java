package com.etiya.customerservice.services.rules;


import com.etiya.customerservice.adapters.CustomerCheckService;
import com.etiya.common.crossCusttingConcerns.exceptions.types.BusinessException;
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
    private CustomerCheckService customerCheckService;
    public void individualCustomerNationalityIdCanNotBeDuplicatedWhenInserted(String nationalityId){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityIdIgnoreCase(nationalityId);

        if(individualCustomer.isPresent()){
            throw new BusinessException(Messages.BusinessErrors.NATIONALITY_ID_EXIST);
        }
    }

    public void checkIfNationalIdentityExists(String nationalityId,String firstName, String lastName,int birthDate) throws Exception {
        if(!customerCheckService.checkIfRealPerson(
                nationalityId,
                firstName,
                lastName,
                birthDate)){
            throw new BusinessException("kullanıcı bulunamadı ! ");
        }
    }
}
