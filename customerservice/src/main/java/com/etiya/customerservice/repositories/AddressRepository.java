package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findByDescriptionIgnoreCase(String description);
}
