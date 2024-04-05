package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.entities.Address;
import com.etiya.customerservice.entities.City;
import com.etiya.customerservice.repositories.AddressRepository;
import com.etiya.customerservice.repositories.CityRepository;
import com.etiya.customerservice.services.abstracts.AddressService;
import com.etiya.customerservice.services.dtos.requests.address.CreateAddressRequest;
import com.etiya.customerservice.services.dtos.requests.address.UpdateAddressRequest;
import com.etiya.customerservice.services.dtos.responses.address.*;
import com.etiya.customerservice.services.dtos.responses.city.GetAllCityResponse;
import com.etiya.customerservice.services.mappers.AddressMapper;
import com.etiya.customerservice.services.mappers.CityMapper;
import com.etiya.customerservice.services.rules.AddressBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressBusinessRules addressBusinessRules;

    @Override
    public GetListResponse<GetAllAddressResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<Address> response = addressRepository.findAll(pageable);

        List<Address> filteredAddresses = response.getContent()
                .stream()
                .filter(address -> address.getDeletedDate() == null)
                .collect(Collectors.toList());
        Page<Address> filteredResponse = new PageImpl<>(filteredAddresses, pageable, response.getTotalElements());

        GetListResponse<GetAllAddressResponse> addressResponse = AddressMapper.INSTANCE.getAllAddressResponseFromAddress(filteredResponse);
        addressResponse.setHasNext(filteredResponse.hasNext());
        addressResponse.setHasPrevious(filteredResponse.hasPrevious());
        return addressResponse;

//        return response.filter(address -> address.getDeletedDate()==null)
//                .map(address -> AddressMapper.INSTANCE.getAllAddressResponseFromAddress(address))
//                .toList();
    }

    @Override
    public GetAddressResponse getById(long id) {
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
    public DeletedAddressResponse delete(long id) {
        Address address = addressRepository.findById(id).get();
        address.setDeletedDate(LocalDateTime.now());
        addressRepository.save(address);
        return AddressMapper.INSTANCE.deletedAddressResponseFromAddress(address);
    }
}
