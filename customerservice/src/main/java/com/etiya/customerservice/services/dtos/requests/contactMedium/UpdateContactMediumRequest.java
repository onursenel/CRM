package com.etiya.customerservice.services.dtos.requests.contactMedium;


import com.etiya.customerservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContactMediumRequest {
    private long id;
    private String email;
    private String homePhone;
    private String fax;
    private String mobilePhone;
}
