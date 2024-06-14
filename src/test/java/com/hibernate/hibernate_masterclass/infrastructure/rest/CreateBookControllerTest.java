package com.hibernate.hibernate_masterclass.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class CreateBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    void createBook() throws Exception {}

    void getBook() throws Exception {}
}
