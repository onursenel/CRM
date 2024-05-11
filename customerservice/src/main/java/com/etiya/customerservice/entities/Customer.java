package com.etiya.customerservice.entities;

import com.etiya.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@Data
@Where(clause = "deletedDate IS NULL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @OneToOne(mappedBy = "customer")
    private ContactMedium contactMedium;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
