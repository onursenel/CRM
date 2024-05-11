package com.etiya.customerservice.services.dtos.responses.contactMedium;


import com.etiya.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetContactMediumResponse {
    private String id;
    private String email;
    private String homePhone;
    private String fax;
    private String mobilePhone;
    private Customer customer;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
