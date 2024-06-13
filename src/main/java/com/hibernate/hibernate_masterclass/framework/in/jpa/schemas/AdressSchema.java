package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class AdressSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(sequenceName = "address_seq", allocationSize = 1, name = "address_seq")
    private Long id;

    @Email
    private String email;

    private String phone;
    private String address;
    private  String city;
    private String state;
    private String country;
}
