package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BookSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String description;
    private String imageUrl;
    private Double price;
    private LocalDate publishDate;
}
