package com.etiya.customerservice.services.rules;

import com.etiya.common.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.repositories.CustomerRepository;
import com.etiya.customerservice.services.messages.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;

    public void customerNotFound(String customerId) {
        Optional<Customer> foundCustomer = customerRepository.findById(customerId);

        if (!foundCustomer.isPresent()) {
            throw new BusinessException(Messages.IdMessage.ID_IS_NOT_FOUND);
        }
    }

    public void deleteCustomer(String id) {
        Customer foundCustomer = customerRepository.findById(id).orElse(null);

        if (foundCustomer.getDeletedDate() != null) {
            throw new BusinessException(Messages.Customer.DELETED_CUSTOMER);
        }
    }
}