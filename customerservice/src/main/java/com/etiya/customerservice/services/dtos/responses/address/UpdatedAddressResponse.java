package com.etiya.customerservice.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedAddressResponse {
    private String id;
    private String street;
    private String houseNumber;
    private String description;
    private LocalDateTime updatedDate;
}
