package com.etiya.catalogservice.services.dtos.responses.campaignResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCampaignResponse {
    private String id;
    private String name;
    private String description;
    private String code;
    private String productId;
}
