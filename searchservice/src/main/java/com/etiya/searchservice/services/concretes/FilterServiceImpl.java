package com.etiya.searchservice.services.concretes;

import com.etiya.common.business.responses.GetListResponse;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.response.GetAllCustomer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void add(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public GetListResponse<GetAllCustomer> search(String nationalityId, String customerId, String accountId, String firstName, String middleName, String lastName, String orderId, Pageable pageable) {
        String nationalityIdentity,
        String id,
        String accountNumber,
        String mobilePhone,
        String firstName,
        String lastName,
        String orderNumber) {

            List<Customer> customers =
                    this.filterRepository.searchResult(
                            nationalityIdentity, id, mobilePhone, accountNumber, firstName, lastName, orderNumber
                    );
            List<GetListResponse> searchResponses = new ArrayList<>();

            for (Customer customer : customers) {
                SearchResponse searchResponse = new SearchResponse();
                searchResponse.setId(customer.getId());
                searchResponse.setFirstName(customer.getFirstName());
                searchResponse.setMiddleName(customer.getMiddleName());
                searchResponse.setLastName(customer.getLastName());
                searchResponse.setRole(customer.getRole());
                searchResponse.setNationalityIdentity(customer.getNationalityIdentity());
                searchResponse.setAccountNumber(customer.getAccountNumber());
                searchResponse.setMobilePhone(customer.getMobilePhone());

                searchResponses.add(searchResponse);
            }
            return searchResponses;
        }
    }
}
