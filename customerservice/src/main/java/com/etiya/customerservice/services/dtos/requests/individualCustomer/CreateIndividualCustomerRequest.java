package com.etiya.customerservice.services.dtos.requests.individualCustomer;

import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCustomerRequest {

    @NotEmpty(message = Messages.IndividualCustomer.FIRST_NAME_IS_NOT_EMPTY)
    @Size(min = 2,message = Messages.IndividualCustomer.FIRST_NAME_MIN_SIZE)
    private String firstName;


    private String middleName;

    @NotEmpty(message = Messages.IndividualCustomer.LAST_NAME_IS_NOT_EMPTY)
    @Size(min = 2,message = Messages.IndividualCustomer.LAST_NAME_MIN_SIZE)
    private String lastName;

    private String gender;


    private String motherName;


    private String fatherName;

    @NotEmpty(message = Messages.IndividualCustomer.NATIONALITY_ID_IS_NOT_EMPTY)
    @Size(min=11,max = 11,message = Messages.IndividualCustomer.NATIONALITY_ID_SIZE_RULE)
    private String nationalityId;

    @Past(message = Messages.IndividualCustomer.BIRTH_DATE_MUST_BE_PAST)
    private LocalDate birthDate;
}
