package com.etiya.searchservice.repository;

import com.etiya.searchservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FilterRepository extends MongoRepository<Customer,String>,FilterRepositoryCustom{
    List<Customer> searchResult(String nationalityId, String id, String mobilePhone,
                                String accountNumber, String firstName, String lastName, String orderNumber);

}
