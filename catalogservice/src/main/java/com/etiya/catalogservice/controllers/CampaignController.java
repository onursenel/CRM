package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.CampaignService;
import com.etiya.catalogservice.services.dtos.requests.campaignRequests.CreateCampaignRequest;
import com.etiya.catalogservice.services.dtos.responses.campaignResponses.CreatedCampaignResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/campaigns")
public class CampaignController {
    private CampaignService campaignService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCampaignResponse add(@Valid @RequestBody CreateCampaignRequest createCampaignRequest){
        return campaignService.add(createCampaignRequest);
    }

}
