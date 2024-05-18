package com.etiya.customerservice.services.dtos.requests.billingAccount;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBillingAccountRequest {
    @NotBlank
    private String name;

    @NotEmpty
    @Size(min = 7, max=100)
    private String description;

    @NotBlank
    private String number;

    @NotBlank
    private String type;

    private String customerId;

    private String addressId;
}
