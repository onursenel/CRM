package com.etiya.customerservice.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCustomerResponse {
    private String id;
    private String email;
    private LocalDateTime createdDate;
}
