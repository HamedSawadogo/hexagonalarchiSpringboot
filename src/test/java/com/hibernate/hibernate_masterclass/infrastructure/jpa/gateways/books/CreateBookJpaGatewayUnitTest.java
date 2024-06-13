package com.hibernate.hibernate_masterclass.infrastructure.jpa.gateways.books;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.hibernate.hibernate_masterclass.common.mappers.BookMapper;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.framework.in.jpa.gateways.BookJpaGateway;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateBookJpaGatewayUnitTest {

  @Mock
  BookJpaRepository bookJpaRepository;
  @Mock
  BookMapper bookMapper;

  @InjectMocks
  BookJpaGateway bookJpaGateway;

  @Test
  void create_new_book_with_valid_infos() {

    Book book = new Book();
    book.setName("book name");
    book.setId(1L);
    book.setPrice(650d);
    book.setDescription("book description");
    book.setPublishDate(LocalDate.now());

    BookSchema bookSchema = new BookSchema();
    bookSchema.setId(1L);
    bookSchema.setName("book schema name");
    bookSchema.setDescription("book schema description");
    bookSchema.setPublishDate(LocalDate.now());

    when(bookMapper.toSchema(book)).thenReturn(bookSchema);
    when(bookMapper.toModel(bookSchema)).thenReturn(book);
    when(bookJpaRepository.save(bookSchema)).thenReturn(bookSchema);

    var bookCreated = bookJpaGateway.create(book);
    assertThat(bookCreated.getId()).isEqualTo(1L);
    assertThat(bookCreated.getName()).isEqualTo("book name");
    assertThat(bookCreated.getPrice()).isEqualTo(650d);
    assertThat(bookCreated.getDescription()).isEqualTo("book description");
    assertThat(bookCreated.getPublishDate()).isNotNull();


    verify(bookJpaRepository).save(bookSchema);
    verify(bookMapper).toSchema(book);
    verify(bookMapper).toModel(bookSchema);

  }
}
