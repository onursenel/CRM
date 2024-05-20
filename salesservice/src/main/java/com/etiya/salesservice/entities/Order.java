package com.etiya.salesservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private String id;
    private String customerId;
    private double totalPrice;
    private List<OrderItem> orderItems;
}
