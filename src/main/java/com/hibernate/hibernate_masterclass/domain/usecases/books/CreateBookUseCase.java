package com.hibernate.hibernate_masterclass.domain.usecases.books;

import com.hibernate.hibernate_masterclass.common.mappers.BookMapper;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BookRequestCommand;
import com.hibernate.hibernate_masterclass.framework.in.jpa.gateways.BookJpaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookUseCase  {
  private final BookJpaGateway bookJpaGateway;
  private final BookMapper bookMapper;

  public Book execute(BookRequestCommand bookRequest) {
    return bookJpaGateway.create(bookMapper.toModel(bookRequest));
  }
}
