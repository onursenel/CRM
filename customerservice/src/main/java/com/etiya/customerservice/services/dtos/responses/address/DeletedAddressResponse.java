package com.etiya.customerservice.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeletedAddressResponse {
    private long id;
    private String description;
}
