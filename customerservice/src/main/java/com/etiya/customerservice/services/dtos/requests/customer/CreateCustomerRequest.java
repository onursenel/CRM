package com.etiya.customerservice.services.dtos.requests.customer;

import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCustomerRequest {

    @NotNull
    @Size(min = 3, max = 30)
    @NotEmpty(message = Messages.Customer.EMAIL_IS_NOT_EMPTY)
    @Email(message = Messages.Customer.INVALID_EMAIL_FORMAT)
    private String email;
}

