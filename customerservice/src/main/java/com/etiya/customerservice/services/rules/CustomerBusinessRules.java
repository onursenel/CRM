package com.etiya.customerservice.services.rules;

import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    /*public Customer checkByCustomerId(long id){
        if(!customerRepository.existsById(id)){
            throw new RuntimeException(id + " id'ye sahip bir customer yoktur");
        }
        return customerRepository.findById(id).get();
    }*/
}
