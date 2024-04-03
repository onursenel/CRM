package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsById(long id);//default olarak true
}
