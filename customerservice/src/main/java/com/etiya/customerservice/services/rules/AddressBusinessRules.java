package com.etiya.customerservice.services.rules;

import com.etiya.customerservice.core.business.abstracts.MessageService;
import com.etiya.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.repositories.AddressRepository;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service    //Ioc ye dahil edilsin
@AllArgsConstructor
public class AddressBusinessRules {
    private AddressRepository addressRepository;
    private MessageService messageService;

    //var olan bir address bir daha eklenmesin

    public void AddressNameCanNotBeDuplicatedWhenInserted(String description){
        Optional<Address> address = addressRepository.findByDescriptionIgnoreCase(description);

        if(address.isPresent()){
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.AddressDescriptionExists));
        }
    }
}
