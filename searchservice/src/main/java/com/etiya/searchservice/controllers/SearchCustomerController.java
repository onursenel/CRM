package com.etiya.searchservice.controllers;


import com.etiya.common.business.responses.GetListResponse;
import com.etiya.searchservice.services.abstracts.FilterService;
import com.etiya.searchservice.services.response.GetAllCustomer;
import lombok.AllArgsConstructor;
import org.springdoc.core.converters.models.Pageable;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("searchservice/api/v1/searchCustomers")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

@GetMapping("/params")
    public ResponseEntity<?> search(
        @RequestParam(required = false) String nationalityId,
        @RequestParam(required = false) String customerId,
        @RequestParam(required = false) String accountId,
        @RequestParam(required = false) String mobilePhone,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String middleName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String orderId,

        @PageableDefault(size = 10, sort = "firstName")Pageable pageable){
        GetListResponse<GetAllCustomer> result = filterService.search(
                nationalityId,
                customerId,
                accountId,
                mobilePhone,
                firstName,
                lastName,
                orderId,
                pageable
        );
        if (result.getTotalElements()>0){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
}
