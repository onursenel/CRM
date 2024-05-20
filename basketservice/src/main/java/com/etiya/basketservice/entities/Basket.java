package com.etiya.basketservice.entities;


@Data
@AllArgsConstructor
@Document(collection = "baskets")
public class Basket {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "customerId")
    private String customerId;

    @Field(name = "totalPrice")
    private double totalPrice;

    private List<BasketItem> basketItems;


    public Basket() {
        this.basketItems = new ArrayList<>();
    }
}
