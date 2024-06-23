package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bag_schema")
    @SequenceGenerator(sequenceName = "bag_schema", allocationSize = 1, name = "bag_schema")
    private Long id;

    private String brand;

    private String color;

    private String type;

    private String material;

    private Integer capacity;

    private Integer compartments;

    private Boolean inStock;

    private String genderTarget;

    private String countryOfOrigin;

    private Integer warrantyPeriod;

    private String modelNumber;

    private String description;

    private Float userRating;

}