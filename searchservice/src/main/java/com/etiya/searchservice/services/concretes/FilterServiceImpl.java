package com.etiya.searchservice.services.concretes;

import com.etiya.searchservice.entities.Customer;
import com.etiya.searchservice.repository.FilterRepository;
import com.etiya.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;

    @Override
    public void add(Customer customer) {
        this.filterRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.filterRepository.save(customer);
    }
}
