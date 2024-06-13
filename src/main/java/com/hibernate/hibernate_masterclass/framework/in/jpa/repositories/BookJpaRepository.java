package com.hibernate.hibernate_masterclass.framework.in.jpa.repositories;

import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookSchema, Long> {
}
