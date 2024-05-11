package com.etiya.customerservice.adapters;

import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.entities.IndividualCustomer;

public interface CustomerCheckService {
    public boolean checkIfRealPerson(String nationalityId,String firstName, String lastName,int birthDate) throws Exception;

}
