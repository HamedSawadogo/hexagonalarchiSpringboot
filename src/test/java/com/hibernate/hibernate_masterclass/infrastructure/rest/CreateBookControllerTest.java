package com.hibernate.hibernate_masterclass.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.hibernate_masterclass.common.uris.Uris;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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


    @Test
    void getBook() throws Exception {
        mockMvc.perform(get(Uris.BASE_URL + Uris.BOOKS)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
        """
                   {
                       "items": [
                           {
                               "id": 1,
                               "name": "name of book",
                               "description": "description",
                               "price": 556.0
                           }
                       ],
                       "page": 0,
                       "limit": 15,
                       "totalItems": 1,
                       "totalPages": 1
                   }
                
                """
                ))
                .andDo(print());
    }
}
