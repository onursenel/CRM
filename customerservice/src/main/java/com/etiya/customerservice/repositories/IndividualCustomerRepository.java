package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,Long> {
}
