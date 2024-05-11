package com.etiya.customerservice.entities;


import com.etiya.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact_medium")
@Data
@Where(clause = "deleted_date IS NULL")
public class ContactMedium extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "mobilePhone")
    private String mobilePhone;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
