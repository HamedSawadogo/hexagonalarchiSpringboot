package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BagSchema {

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
    private String dimensions;
    private Double weight;
    private Double price;
    private String manufactureDate;
    private Boolean inStock;
    private String genderTarget;
    private String countryOfOrigin;
    private Integer warrantyPeriod;
    private String modelNumber;
    private String description;
    private Float userRating;
    private String imagePath;
    private String category;
    private String closureType;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @MapsId
    private UserSchema owner;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bag_books")
    private Set<BookSchema> books = new HashSet<>();
}
