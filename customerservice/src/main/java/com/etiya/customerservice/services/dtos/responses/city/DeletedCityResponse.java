package com.etiya.customerservice.services.dtos.responses.city;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeletedCityResponse {
    private long id;
    private String name;
}
