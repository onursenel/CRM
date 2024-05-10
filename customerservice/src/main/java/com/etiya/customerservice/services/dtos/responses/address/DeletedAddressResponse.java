package com.etiya.customerservice.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedAddressResponse {
    private String id;
    private String street;
    private String houseNumber;
    private String description;
    private LocalDateTime deletedDate;
}
