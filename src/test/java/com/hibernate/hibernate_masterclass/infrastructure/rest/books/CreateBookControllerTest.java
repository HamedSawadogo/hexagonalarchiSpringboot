package com.hibernate.hibernate_masterclass.infrastructure.rest.books;

import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.commons.BaseIntegrationTest;
import com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos.BookRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
class CreateBookControllerTest extends BaseIntegrationTest {


   @Test
   void createBook_with_valid_data_should_be_created_201() throws Exception {
       var bookRequest = BookRequestDto.builder()
               .name("Clean Code")
               .description("the of of clean code that Software Engineer should be know")
               .price(30d)
               .imageUrl("http://image.jpg")
               .build();

       mockMvc.perform(post(Uris.BASE_URL + Uris.BOOKS)
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(bookRequest)))
               .andExpect(status().isCreated())
               .andDo(print());
   }
}
