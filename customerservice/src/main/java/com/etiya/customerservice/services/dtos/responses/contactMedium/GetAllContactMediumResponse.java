package com.etiya.customerservice.services.dtos.responses.contactMedium;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GetAllContactMediumResponse {
    private String id;
    private String email;
    private String homePhone;
    private String fax;
    private String mobilePhone;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;
}
