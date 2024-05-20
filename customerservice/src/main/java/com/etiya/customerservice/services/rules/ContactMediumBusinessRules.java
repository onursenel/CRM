package com.etiya.customerservice.services.rules;


import com.etiya.common.business.abstracts.MessageService;
import com.etiya.common.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.ContactMedium;
import com.etiya.customerservice.repositories.ContactMediumRepository;
import com.etiya.customerservice.services.abstracts.CustomerService;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactMediumBusinessRules {
    private ContactMediumRepository contactMediumRepository;
    private MessageService messageService;
    private CustomerService customerService;

    public void EmailCanNotBeDuplicatedWhenInserted(String email){
        if(contactMediumRepository.existsByEmail(email)){
            throw new BusinessException(Messages.ContactMediumMessage.ContactMediumEmailExists);
        }
    }

    public void checkByCustomerId(String id){
        customerService.getById(id);
    }
}
