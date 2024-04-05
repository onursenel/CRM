package com.etiya.customerservice.services.dtos.requests.address;

import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotNull(message = Messages.IdMessage.ID_IS_NOT_NULL)
    private long cityId;

    @NotNull(message = Messages.IdMessage.ID_IS_NOT_NULL)
    private long customerId;

    @NotNull
    @NotEmpty
    @Size(min = 7, max=100)
    private String description;
}