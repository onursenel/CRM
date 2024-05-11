package com.etiya.customerservice.services.dtos.responses.address;

import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAddressResponse {
    private String id;
    private String street;
    private String houseNumber;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
