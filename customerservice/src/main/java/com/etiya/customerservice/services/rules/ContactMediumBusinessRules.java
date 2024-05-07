package com.etiya.customerservice.services.rules;


import com.etiya.customerservice.core.business.abstracts.MessageService;
import com.etiya.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.entities.ContactMedium;
import com.etiya.customerservice.repositories.AddressRepository;
import com.etiya.customerservice.repositories.ContactMediumRepository;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactMediumBusinessRules {
    private ContactMediumRepository contactMediumRepository;
    private MessageService messageService;

    public void EmailCanNotBeDuplicatedWhenInserted(String email){
        Optional<ContactMedium> contactMedium = contactMediumRepository.findByEmailIgnoreCase(email);

        if(contactMedium.isPresent()){
            throw new BusinessException(messageService.getMessage(Messages.ContactMediumMessage.ContactMediumEmailExists));
        }
    }
}
