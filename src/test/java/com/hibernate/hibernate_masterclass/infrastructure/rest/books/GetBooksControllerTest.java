package com.hibernate.hibernate_masterclass.infrastructure.rest.books;

import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.commons.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/

class GetBooksControllerTest extends BaseIntegrationTest {


    @Test
    void get_books_should_returned_200_ok() throws Exception {
        mockMvc.perform(get(Uris.BASE_URL + Uris.BOOKS)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
