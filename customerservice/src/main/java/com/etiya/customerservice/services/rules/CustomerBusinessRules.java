package com.etiya.customerservice.services.rules;

import com.etiya.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.repositories.CityRepository;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.services.messages.Messages;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;

    public void customerNotFound(long customerId) {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);

        if (!foundCustomer.isPresent()) {
            throw new BusinessException(Messages.IdMessage.ID_IS_NOT_FOUND);
        }
    }

    public void deleteCustomer(long id) {
        Customer foundCustomer = customerRepository.findById(id).orElse(null);

        if (foundCustomer.getDeletedDate() != null) {
            throw new BusinessException(Messages.Customer.DELETED_CUSTOMER);
        }
    }

    public void customerEmailCanNotBeDuplicatedWhenInserted(String email) {
        Optional<Customer> customer = customerRepository.findByEmailIgnoreCase(email);

        if (customer.isPresent()) {
            throw new BusinessException(Messages.Customer.EMAIL_EXIST);
        }
    }
}