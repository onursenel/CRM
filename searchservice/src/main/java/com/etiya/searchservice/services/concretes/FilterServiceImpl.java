package com.etiya.searchservice.services.concretes;

import com.etiya.common.business.responses.GetListResponse;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.dtos.responses.SearchResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void addCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return this.filterRepository.findById(id).get();
    }

    @Override
    public List<SearchResponse> getAll() {
        List<Customer> customerList = filterRepository.findAll();

        List<SearchResponse> searchResponses = new ArrayList<>();
        for (Customer customer : customerList) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setRole(customer.getRole());
            searchResponse.setNationalityId(customer.getNationalityId());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }

    @Override
    public List<SearchResponse> search(String nationalityId, String id, String accountNumber, String mobilePhone, String firstName, String lastName, String orderNumber) {
        List<Customer> customers =
                this.filterRepository.searchResult(
                        nationalityId, id, mobilePhone, accountNumber, firstName, lastName, orderNumber
                );
        List<SearchResponse> searchResponses = new ArrayList<>();

        for (Customer customer : customers) {
            SearchResponse searchResponse = new SearchResponse();
            searchResponse.setId(customer.getId());
            searchResponse.setFirstName(customer.getFirstName());
            searchResponse.setMiddleName(customer.getMiddleName());
            searchResponse.setLastName(customer.getLastName());
            searchResponse.setRole(customer.getRole());
            searchResponse.setNationalityId(customer.getNationalityId());

            searchResponses.add(searchResponse);
        }
        return searchResponses;
    }
    }



