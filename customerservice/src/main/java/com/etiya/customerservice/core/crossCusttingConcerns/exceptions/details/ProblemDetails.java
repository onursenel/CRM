package com.etiya.customerservice.core.crossCusttingConcerns.exceptions.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    private String title;
    private String detail;
    private String type;
    private String status;

}
