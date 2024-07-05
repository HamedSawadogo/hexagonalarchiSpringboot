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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String dimensions;
    private Double weight;
    private Double price;
    private String manufactureDate;
    private String imagePath;
    private String category;
    private String closureType;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    private UserSchema owner;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bag_books")
    private Set<BookSchema> books = new HashSet<>();
}
