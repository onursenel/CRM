package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.entities.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactMediumRepository extends JpaRepository<ContactMedium,String> {
    Optional<ContactMedium> findByEmailIgnoreCase(String email);
}
