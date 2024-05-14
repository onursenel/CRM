package com.etiya.common.crossCusttingConcerns.exceptions.handlers;

import com.etiya.common.crossCusttingConcerns.exceptions.types.BusinessException;
import com.etiya.common.crossCusttingConcerns.exceptions.details.BusinessProblemDetails;
import com.etiya.common.crossCusttingConcerns.exceptions.details.ValidationProblemDetails;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class}) //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        Map<String, String> errorDetails = new HashMap<>();
        for (FieldError error : fieldErrors) {
            errorDetails.put(error.getField(), error.getDefaultMessage());
        }

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setErrors(errorDetails);

        return problemDetails;

    }

/*    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleException() {
        return new ProblemDetails("Unknown Error","Some error occurred."
                ,"https://turkcell.com/exceptions/unknown","400");
    }*/

}
