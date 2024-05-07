package com.etiya.customerservice.services.dtos.responses.contactMedium;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedContactMediumResponse {
    private long id;
    private String email;
    private String homePhone;
    private String fax;
    private String mobilePhone;
    private LocalDateTime updatedDate;
}
