package com.etiya.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "status")
    private String status;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}
