package com.etiya.customerservice.services.concretes;

import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiya.common.business.paging.PageInfo;
import com.etiya.common.business.responses.GetListResponse;
import com.etiya.common.events.customers.CustomerDeletedEvent;
import com.etiya.common.events.customers.CustomerUpdatedEvent;
import com.etiya.customerservice.entities.IndividualCustomer;
import com.etiya.customerservice.kafka.producers.CustomerCreatedProducer;
import com.etiya.customerservice.kafka.producers.CustomerUpdatedProducer;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CheckNationalityIdentityRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiya.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiya.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerCreatedProducer customerCreatedProducer;
    private CustomerUpdatedProducer customerUpdatedProducer;

    @Override
    public GetIndividualCustomerResponse getById(String id) {
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
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) throws Exception {
        individualCustomerBusinessRules.individualCustomerNationalityIdCanNotBeDuplicatedWhenInserted(createIndividualCustomerRequest.getNationalityId());
        individualCustomerBusinessRules.checkIfNationalIdentityExists(
                createIndividualCustomerRequest.getNationalityId(),
                createIndividualCustomerRequest.getFirstName(),
                createIndividualCustomerRequest.getLastName(),
                createIndividualCustomerRequest.getBirthDate().getYear()
                );

        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);

        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);
        createdIndividualCustomerResponse.setCustomerId(createdIndividualCustomer.getId());
        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent(
                createdIndividualCustomerResponse.getCustomerId(),
                createdIndividualCustomerResponse.getFirstName(),
                createdIndividualCustomerResponse.getMiddleName(),
                createdIndividualCustomerResponse.getLastName(),
                createdIndividualCustomerResponse.getGender(),
                createdIndividualCustomerResponse.getMotherName(),
                createdIndividualCustomerResponse.getFatherName(),
                createdIndividualCustomerResponse.getNationalityId(),
                createdIndividualCustomerResponse.getBirthDate()
                );  //ihtiyaç duyulan her şey
        customerCreatedProducer.sendMessage(customerCreatedEvent);

        return  createdIndividualCustomerResponse;
    }

    @Override
    public UpdatedIndividualCustomerResponse update(UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateIndividualCustomerRequest(updateIndividualCustomerRequest);
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        UpdatedIndividualCustomerResponse updatedIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.updatedIndividualCustomerResponseFromIndividualCustomer(updatedIndividualCustomer);

        CustomerUpdatedEvent customerUpdatedEvent = new CustomerUpdatedEvent(
                updatedIndividualCustomerResponse.getId(),
                updatedIndividualCustomerResponse.getFirstName(),
                updatedIndividualCustomerResponse.getMiddleName(),
                updatedIndividualCustomerResponse.getLastName(),
                updatedIndividualCustomerResponse.getGender(),
                updatedIndividualCustomerResponse.getMotherName(),
                updatedIndividualCustomerResponse.getFatherName(),
                updatedIndividualCustomerResponse.getNationalityId(),
                updatedIndividualCustomerResponse.getBirthDate()
        );  //ihtiyaç duyulan her şey
        customerUpdatedProducer.sendMessage(customerUpdatedEvent);
        return  updatedIndividualCustomerResponse;

    }

    @Override
    public DeletedIndividualCustomerResponse delete(String id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);


        return IndividualCustomerMapper.INSTANCE.deletedIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }

    @Override
    public Boolean checkIfNationalIdentityExists(CheckNationalityIdentityRequest checkNationalityIdentityRequest) throws Exception {
        return individualCustomerBusinessRules.checkIfNationalIdentityExists(
                checkNationalityIdentityRequest.getNationalityId(),
                checkNationalityIdentityRequest.getFirstName(),
                checkNationalityIdentityRequest.getLastName(),
                checkNationalityIdentityRequest.getBirthDate()
        );
    }
}
