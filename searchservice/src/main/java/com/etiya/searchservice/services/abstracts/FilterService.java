package com.etiya.searchservice.services.abstracts;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.dtos.responses.SearchResponse;

import java.util.List;


public interface FilterService {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer findById(String id);

    List<SearchResponse> getAll();
    List<SearchResponse> search(
            String nationalityId,String id,String accountNumber,String mobilePhone,String firstName,
            String lastName,String orderNumber
    );
}
