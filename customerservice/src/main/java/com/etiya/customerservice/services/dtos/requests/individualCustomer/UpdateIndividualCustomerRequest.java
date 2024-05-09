package com.etiya.customerservice.services.dtos.requests.individualCustomer;


import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateIndividualCustomerRequest {


    @NotNull(message = Messages.IdMessage.ID_IS_NOT_NULL)
    private String id;

    @NotEmpty(message = Messages.IndividualCustomer.FIRST_NAME_IS_NOT_EMPTY)
    @Size(min = 2,message = Messages.IndividualCustomer.FIRST_NAME_MIN_SIZE)
    private String firstName;


    @Size(min=2,message = Messages.IndividualCustomer.MIDDLE_NAME_MIN_SIZE)
    private String middleName;

    @NotEmpty(message = Messages.IndividualCustomer.LAST_NAME_IS_NOT_EMPTY)
    @Size(min = 2,message = Messages.IndividualCustomer.LAST_NAME_MIN_SIZE)
    private String lastName;

    private String gender;

    @Size(min = 2,message = Messages.IndividualCustomer.MOTHER_NAME_MIN_SIZE)
    private String motherName;

    @Size(min = 2,message = Messages.IndividualCustomer.FATHER_NAME_MIN_SIZE)
    private String fatherName;

    @NotEmpty(message = Messages.IndividualCustomer.NATIONALITY_ID_IS_NOT_EMPTY)
    @Size(min=11,max = 11,message = Messages.IndividualCustomer.NATIONALITY_ID_SIZE_RULE)
    private String nationalityId;

    @Past(message = Messages.IndividualCustomer.BIRTH_DATE_MUST_BE_PAST)
    private LocalDate birthDate;
}
