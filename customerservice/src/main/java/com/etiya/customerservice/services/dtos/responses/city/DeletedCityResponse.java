package com.etiya.customerservice.services.dtos.responses.city;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeletedCityResponse {
    private String id;
    private String name;
    private LocalDateTime deletedDate;
}
