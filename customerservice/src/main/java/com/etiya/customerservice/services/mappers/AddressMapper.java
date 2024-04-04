package com.etiya.customerservice.services.mappers;

import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);                //instance

    GetAllAddressResponse getAllAddressResponseFromAddress(Address address);        //address parametresini getalladdress parametresine çevriliyor

    GetAddressResponse getAddressResponseFromAddress(Address address);


    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);     //createaddressrequestinden bana address oluştur parametrem bu
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);


    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);


    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);
}
