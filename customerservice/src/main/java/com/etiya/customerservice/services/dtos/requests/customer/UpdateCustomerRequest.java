package com.etiya.customerservice.services.dtos.requests.customer;

import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCustomerRequest {
    @NotNull(message = Messages.IdMessage.ID_IS_NOT_NULL)
    private String id;

}
