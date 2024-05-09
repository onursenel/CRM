package com.etiya.customerservice.entities;

import com.etiya.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
@Data
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;


    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
