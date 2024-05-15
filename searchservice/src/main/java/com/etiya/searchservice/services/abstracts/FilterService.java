package com.etiya.searchservice.services.abstracts;

import com.etiya.common.business.responses.GetListResponse;
import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.services.response.GetAllCustomer;
import org.springframework.data.domain.Pageable;


public interface FilterService {
    void add(Customer customer);
    void update(Customer customer);

    GetListResponse<GetAllCustomer>search(
            String nationalityId,
            String customerId,
            String accountId,
            String firstName,
            String middleName,
            String lastName,
            String orderId,
            Pageable pageable
    );
}
