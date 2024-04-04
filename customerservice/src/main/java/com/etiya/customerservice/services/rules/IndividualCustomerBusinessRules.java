package com.etiya.customerservice.services.rules;


import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class IndividualCustomerBusinessRules {
    private IndividualCustomerRepository individualCustomerRepository;

}
