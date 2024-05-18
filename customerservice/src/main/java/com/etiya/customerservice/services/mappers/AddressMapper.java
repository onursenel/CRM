package com.etiya.customerservice.services.mappers;

import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);                //instance

    @Mapping(source = "address.content",target = "items")
    GetListResponse<GetAllAddressResponse> getAllAddressResponseFromAddress(Page<Address> address);       //address parametresini getalladdress parametresine çevriliyor

    GetAddressResponse getAddressResponseFromAddress(Address address);

    @Mapping(target = "customer.id",source = "customerId")
    @Mapping(target = "city.id",source = "cityId")
    Address addressFromCreateAddressRequest(CreateAddressRequest createAddressRequest);     //createaddressrequestinden bana address oluştur parametrem bu
    CreatedAddressResponse createdAddressResponseFromAddress(Address address);

    Address addressFromUpdateAddressRequest(UpdateAddressRequest updateAddressRequest);
    UpdatedAddressResponse updatedAddressResponseFromAddress(Address address);


    DeletedAddressResponse deletedAddressResponseFromAddress(Address address);
}
