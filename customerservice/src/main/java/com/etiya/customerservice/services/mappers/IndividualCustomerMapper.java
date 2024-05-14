package com.etiya.customerservice.services.mappers;


import com.etiya.common.business.responses.GetListResponse;
import com.etiya.customerservice.entities.IndividualCustomer;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.services.dtos.responses.individualCustomer.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface IndividualCustomerMapper {

    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    @Mapping(source = "individualCustomer.content",target = "items")
    GetListResponse<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponseFromIndividualCustomer(Page<IndividualCustomer> individualCustomer);
    GetIndividualCustomerResponse getIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromCreateIndividualCustomerRequest(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    CreatedIndividualCustomerResponse createdIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    UpdatedIndividualCustomerResponse updatedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromUpdateIndividualCustomerRequest(UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    DeletedIndividualCustomerResponse deletedIndividualCustomerResponseFromIndividualCustomer(IndividualCustomer individualCustomer);

}
