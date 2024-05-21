package com.etiya.customerservice.services.dtos.responses.individualCustomer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedIndividualCustomerResponse {
    private String customerId;
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String motherName;
    private String fatherName;
    private String nationalityId;
    private LocalDate birthDate;
    private LocalDateTime createdDate;
}
