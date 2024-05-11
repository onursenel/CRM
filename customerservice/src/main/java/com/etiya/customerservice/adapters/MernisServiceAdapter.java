package com.etiya.customerservice.adapters;

import com.etiya.customerservice.outservices.mernis.AWFKPSPublicSoap;
import org.springframework.stereotype.Service;


@Service
public class MernisServiceAdapter implements CustomerCheckService{
    @Override
    public boolean checkIfRealPerson(String nationalityId,String firstName, String lastName,int birthDate) throws Exception {
        AWFKPSPublicSoap client = new AWFKPSPublicSoap();
        return client.TCKimlikNoDogrula(
                Long.parseLong(nationalityId),
                firstName,
                lastName,
                birthDate
                );
    }
}
