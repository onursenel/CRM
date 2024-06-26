package com.etiya.searchservice.kafka;


import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiya.common.events.customers.CustomerUpdatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class CustomerUpdatedConsumer {
    private FilterService filterService;

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerUpdatedConsumer.class);
    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
    private void consume(CustomerUpdatedEvent customerUpdatedEvent){
        Customer customer = filterService.findById(customerUpdatedEvent.getId());
        customer.setId(customerUpdatedEvent.getId());
        customer.setFirstName(customerUpdatedEvent.getFirstName());
        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
        customer.setLastName(customerUpdatedEvent.getLastName());
        customer.setNationalityId(customerUpdatedEvent.getNationalityId());


        LOGGER.info(String.format("customer updated consumer success =>%s",customerUpdatedEvent.toString()));
        this.filterService.updateCustomer(customer);
    }
}
