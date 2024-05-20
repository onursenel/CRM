package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
   // boolean existsById(long id);//default olarak true

}
