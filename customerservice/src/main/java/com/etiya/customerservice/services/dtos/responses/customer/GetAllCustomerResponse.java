package com.etiya.customerservice.services.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomerResponse {
    private String id;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
