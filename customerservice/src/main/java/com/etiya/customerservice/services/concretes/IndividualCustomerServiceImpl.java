package com.etiya.customerservice.services.concretes;

import com.etiya.common.events.customers.CustomerCreatedEvent;
import com.etiya.customerservice.core.business.paging.PageInfo;
import com.etiya.customerservice.core.business.responses.GetListResponse;
import com.etiya.customerservice.entities.Customer;
import com.etiya.customerservice.entities.IndividualCustomer;
import com.etiya.customerservice.kafka.producers.CustomerCreatedProducer;
import com.etiya.customerservice.repositories.IndividualCustomerRepository;
import com.etiya.customerservice.services.abstracts.IndividualCustomerService;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import com.etiya.customerservice.services.mappers.IndividualCustomerMapper;
import com.etiya.customerservice.services.rules.IndividualCustomerBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    private IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private IndividualCustomerRepository individualCustomerRepository;
    private CustomerCreatedProducer customerCreatedProducer;

    @Override
    public GetIndividualCustomerResponse getById(String id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }

    @Override
    public GetListResponse<GetAllIndividualCustomerResponse> getAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPage(),pageInfo.getSize());
        Page<IndividualCustomer> response = individualCustomerRepository.findAll(pageable);

//        List<IndividualCustomer> filteredIndividualCustomer = response.getContent()
//                .stream()
//                .filter(individualCustomer -> individualCustomer.getDeletedDate() == null)
//                .collect(Collectors.toList());
        //Page<IndividualCustomer> filteredResponse = new PageImpl<>(individualCustomerList, pageable, response.getTotalElements());

        GetListResponse<GetAllIndividualCustomerResponse> individualCustomerResponse = IndividualCustomerMapper.INSTANCE.getAllIndividualCustomerResponseFromIndividualCustomer(response);
        individualCustomerResponse.setHasNext(response.hasNext());
        individualCustomerResponse.setHasPrevious(response.hasPrevious());
        return individualCustomerResponse;
    }

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerNationalityIdCanNotBeDuplicatedWhenInserted(createIndividualCustomerRequest.getNationalityId());

        IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateIndividualCustomerRequest(createIndividualCustomerRequest);
        individualCustomer.setCustomer(new Customer());
        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);

        CreatedIndividualCustomerResponse createdIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.createdIndividualCustomerResponseFromIndividualCustomer(createdIndividualCustomer);

        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent(
                createdIndividualCustomerResponse.getId(), createdIndividualCustomerResponse.getFirstName());  //ihtiyaç duyulan her şey
        customerCreatedProducer.sendMessage(customerCreatedEvent);

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
    public DeletedIndividualCustomerResponse delete(String id) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(id).get();
        individualCustomer.setDeletedDate(LocalDateTime.now());
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.deletedIndividualCustomerResponseFromIndividualCustomer(individualCustomer);
    }
}
