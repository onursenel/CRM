package com.etiya.customerservice.services.concretes;

import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.entities.IndividualCustomer;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.city.GetAllCityResponse;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiya.customerservice.services.mappers.CityMapper;
import com.etiya.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiya.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private IndividualCustomerRepository individualCustomerRepository;

    @Override
    public GetIndividualCustomerResponse getById(long id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }

    @Override
    public GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAll(pageable);

        GetListResponse<GetAllIndividualCustomerResponse> individualCustomerResponse = IndividualCustomerMapper.INSTANCE.getAllIndividualCustomerResponseFromIndividualCustomer(response);
        individualCustomerResponse.setHasNext(response.hasNext());
        individualCustomerResponse.setHasPrevious(response.hasPrevious());

        return individualCustomerResponse;
    }

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);

        return  createdIndividualCustomerResponse;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);

        return  updatedIndividualCustomerResponse;

    }

    @Override
    public DeletedIndividualCustomerResponse delete(long id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.deletedIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }
}
