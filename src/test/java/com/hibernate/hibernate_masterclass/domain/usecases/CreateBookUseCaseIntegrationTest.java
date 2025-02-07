package com.hibernate.hibernate_masterclass.domain.usecases;

import com.hibernate.hibernate_masterclass.domain.usecases.books.CreateBookUseCase;
import com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos.BookRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CreateBookUseCaseIntegrationTest {

  @Autowired
  CreateBookUseCase createBookUseCase;

  @Test
  void create_book_use_case_test() {
    var requestCommand = BookRequestDto.builder()
            .name("name of the book")
            .description("description of the book")
            .price(6500d)
            .build();
    var bookCreated = createBookUseCase.execute(requestCommand);
    System.err.println(bookCreated);
  }
}
