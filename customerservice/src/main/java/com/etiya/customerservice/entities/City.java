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
@Table(name = "cities")
@Data
public class City extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;
}
