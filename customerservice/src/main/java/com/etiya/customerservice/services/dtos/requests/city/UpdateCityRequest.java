package com.etiya.customerservice.services.dtos.requests.city;


import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityRequest {
    @NotNull(message = Messages.IdMessage.ID_IS_NOT_NULL)
    private long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;
}
