package com.hibernate.hibernate_masterclass.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public abstract class BaseIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    BookJpaRepository bookJpaRepository;

    @AfterEach
    void clearBd() {
        bookJpaRepository.deleteAll();
    }
}
