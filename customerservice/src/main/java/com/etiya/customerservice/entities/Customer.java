package com.etiya.customerservice.entities;

import com.etiya.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@Data
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "customer")
    private IndividualCustomer individualCustomer;

    @OneToOne(mappedBy = "customer")
    private ContactMedium contactMedium;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
