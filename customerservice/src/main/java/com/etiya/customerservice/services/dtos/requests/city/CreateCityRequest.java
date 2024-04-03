package com.etiya.customerservice.services.dtos.requests.city;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCityRequest {
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;
}
