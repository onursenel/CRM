package com.etiya.basketservice.entities;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItem {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "productOfferId")
    private String productOfferId;

    @Field(name = "productOfferName")
    private String productOfferName;

    @Field(name = "price")
    private double price;

    @Field(name = "campaignId")
    private String campaignId;
}
