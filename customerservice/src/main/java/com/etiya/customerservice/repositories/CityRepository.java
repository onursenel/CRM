package com.etiya.customerservice.repositories;

import com.etiya.customerservice.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,String> {
    Optional<City> findByNameIgnoreCase(String name);
}
