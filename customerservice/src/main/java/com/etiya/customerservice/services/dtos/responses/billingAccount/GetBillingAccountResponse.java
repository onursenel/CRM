package com.etiya.customerservice.services.dtos.responses.billingAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBillingAccountResponse {
    private String id;
    private String status;
    private String number;
    private String name;
    private String type;
    private String customerId;
    private String addressId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
