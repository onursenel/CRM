package com.etiya.searchservice.kafka;

import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerCreatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-created", groupId = "create-customer")
    private void consume(CustomerCreatedEvent customerCreatedEvent){
        Customer customer = new Customer();
        customer.setId(customerCreatedEvent.getId());
        customer.setFirstName(customerCreatedEvent.getFirstName());
        customer.setMiddleName(customerCreatedEvent.getMiddleName());
        customer.setLastName(customerCreatedEvent.getLastName());
        customer.setGender(customerCreatedEvent.getGender());
        customer.setMotherName(customerCreatedEvent.getMotherName());
        customer.setFatherName(customerCreatedEvent.getFatherName());
        customer.setNationalityId(customerCreatedEvent.getNationalityId());
        customer.setBirthDate(customerCreatedEvent.getBirthDate());


        LOGGER.info(String.format("customer created consumer success =>%s",customerCreatedEvent.toString()));
        this.filterService.add(customer);
    }

}
