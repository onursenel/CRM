package com.etiya.customerservice.services.concretes;

import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.repositories.AddressRepository;
import com.etiya.customerservice.services.abstracts.AddressService;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import com.etiya.customerservice.services.mappers.AddressMapper;
import com.etiya.customerservice.services.rules.AddressBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;

    @Override
    public GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Address> response = addressRepository.findAll(pageable);


        GetListResponse<GetAllAddressResponse> addressResponse = AddressMapper.INSTANCE.getAllAddressResponseFromAddress(response);

        addressResponse.setHasNext(response.hasNext());
        addressResponse.setHasPrevious(response.hasPrevious());
        return addressResponse;


    }

    @Override
    public GetAddressResponse getById(String id) {
        Address address = addressRepository.findById(id).get();
        return AddressMapper.INSTANCE.getAddressResponseFromAddress(address);
    }

    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        addressBusinessRules.AddressNameCanNotBeDuplicatedWhenInserted(createAddressRequest.getDescription());
        Address address = AddressMapper.INSTANCE.addressFromCreateAddressRequest(createAddressRequest);
        Address createdAddress = addressRepository.save(address);


        CreatedAddressResponse createdAddressResponse = AddressMapper.INSTANCE.createdAddressResponseFromAddress(createdAddress);
        return createdAddressResponse;
    }
    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        addressBusinessRules.AddressNameCanNotBeDuplicatedWhenInserted(updateAddressRequest.getDescription());
        Address address =AddressMapper.INSTANCE.addressFromUpdateAddressRequest(updateAddressRequest);
        Address updatedAddress = addressRepository.save(address);

        UpdatedAddressResponse updatedAddressResponse = AddressMapper.INSTANCE.updatedAddressResponseFromAddress(updatedAddress);
        return updatedAddressResponse;

    }

    @Override
    public DeletedAddressResponse delete(String id) {
        Address address = addressRepository.findById(id).get();
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);
        return AddressMapper.INSTANCE.deletedAddressResponseFromAddress(address);
    }
}
