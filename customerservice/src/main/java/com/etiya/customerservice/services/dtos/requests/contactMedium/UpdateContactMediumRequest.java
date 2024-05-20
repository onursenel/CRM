package com.etiya.customerservice.services.dtos.requests.contactMedium;


import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.services.messages.Messages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateContactMediumRequest {
    private String id;

    @NotNull
    @Size(min = 3, max = 30)
    @NotEmpty(message = Messages.ContactMediumMessage.EMAIL_IS_NOT_EMPTY)
    @Email(message = Messages.ContactMediumMessage.INVALID_EMAIL_FORMAT)
    private String email;
    private String homePhone;
    private String fax;
    private String mobilePhone;
    private String customerId;
}
