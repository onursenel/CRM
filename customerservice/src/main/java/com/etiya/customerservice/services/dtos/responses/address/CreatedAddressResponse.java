package com.etiya.customerservice.services.dtos.responses.address;

import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private String id;
    private String street;
    private String houseNumber;
    private String description;
    private LocalDateTime createdDate;
}
