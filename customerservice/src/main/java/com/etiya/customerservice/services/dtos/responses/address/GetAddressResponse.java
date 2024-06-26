package com.etiya.customerservice.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAddressResponse {
    private String id;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
