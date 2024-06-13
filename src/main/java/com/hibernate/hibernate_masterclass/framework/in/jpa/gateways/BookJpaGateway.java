package com.hibernate.hibernate_masterclass.framework.in.jpa.gateways;

import com.hibernate.hibernate_masterclass.common.mappers.BookMapper;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.models.book.gateway.BookGateway;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookJpaGateway implements BookGateway {

  private final BookJpaRepository bookJpaRepository;
  private final BookMapper bookMapper;


  @Override
  public Book create(Book book) {
    var bookSchema = bookJpaRepository.save(bookMapper.toSchema(book));
    return bookMapper.toModel(bookSchema);
  }
}
