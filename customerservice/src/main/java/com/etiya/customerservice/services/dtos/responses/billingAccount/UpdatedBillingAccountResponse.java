package com.etiya.customerservice.services.dtos.responses.billingAccount;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedBillingAccountResponse {
    private String id;
    private String status;
    private String number;
    private String name;
    private String type;
    private String customerId;
    private String addressId;
}
