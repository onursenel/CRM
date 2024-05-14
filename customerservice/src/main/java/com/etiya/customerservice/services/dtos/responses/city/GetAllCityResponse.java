package com.etiya.customerservice.services.dtos.responses.city;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCityResponse {
    private String id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
