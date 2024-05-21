package com.etiya.customerservice.services.dtos.requests.individualCustomer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckNationalityIdentityRequest {
    private String nationalityId;
    private String firstName;
    private String lastName;
    private int birthDate;
}
