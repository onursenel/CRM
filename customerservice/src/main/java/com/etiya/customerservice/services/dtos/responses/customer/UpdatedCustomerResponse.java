package com.etiya.customerservice.services.dtos.responses.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedCustomerResponse {
    private long id;
    private String email;
    private LocalDateTime updatedDate;
}
