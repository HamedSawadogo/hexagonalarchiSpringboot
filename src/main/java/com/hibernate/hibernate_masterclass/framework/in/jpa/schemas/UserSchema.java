package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
    private Long id;
    private String name;
    private String password;
    private String sexe;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @MapsId
    private AdressSchema address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<BagSchema> bags = new LinkedHashSet<>();

    @ManyToMany(cascade =
    {       CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}
    )
    private Set<Teacher> teachers  = new LinkedHashSet<>();
}
