package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,String> {
    Optional<IndividualCustomer> findByNationalityIdIgnoreCase(String nationalityId);
}
