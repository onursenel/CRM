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

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerUpdatedConsumer.class);
    private FilterService filterService;
    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
    private void consume(CustomerUpdatedEvent customerUpdatedEvent){
        Customer customer = new Customer();
        customer.setId(customerUpdatedEvent.getId());
        customer.setFirstName(customerUpdatedEvent.getFirstName());
        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
        customer.setLastName(customerUpdatedEvent.getLastName());
        customer.setGender(customerUpdatedEvent.getGender());
        customer.setMotherName(customerUpdatedEvent.getMotherName());
        customer.setFatherName(customerUpdatedEvent.getFatherName());
        customer.setNationalityId(customerUpdatedEvent.getNationalityId());
        customer.setBirthDate(customerUpdatedEvent.getBirthDate());


        LOGGER.info(String.format("customer updated consumer success =>%s",customerUpdatedEvent.toString()));
        this.filterService.update(customer);
    }
}
