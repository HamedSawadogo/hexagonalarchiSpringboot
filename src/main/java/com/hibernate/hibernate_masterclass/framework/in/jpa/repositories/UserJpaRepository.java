package com.hibernate.hibernate_masterclass.framework.in.jpa.repositories;

import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.UserSchema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpaRepository extends JpaRepository<UserSchema, Long> {
    @EntityGraph(attributePaths = {"books", "address", "bags"})
    Page<UserSchema> findAll(Pageable pageable);
}