package com.hibernate.hibernate_masterclass.framework.in.jpa.schemas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<UserSchema> students = new HashSet<>();
}
