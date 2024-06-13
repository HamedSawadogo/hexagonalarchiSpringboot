package com.hibernate.hibernate_masterclass.common.mappers;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BookRequestCommand;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  public  Book toModel(BookRequestCommand command) {
    Book book = new Book();
    book.setDescription(command.getDescription());
    book.setName(command.getName());
    book.setPrice(command.getPrice());
    book.setPublishDate(LocalDate.now());
    return book;
  }

  public  Book toModel(BookSchema bookSchema) {
    Book book = new Book();
    book.setId(bookSchema.getId());
    book.setDescription(bookSchema.getDescription());
    book.setName(bookSchema.getName());
    book.setPrice(bookSchema.getPrice());
    return book;
  }

  public  BookSchema toSchema(Book book) {
     BookSchema bookSchema = new BookSchema();
     bookSchema.setId(book.getId());
     bookSchema.setDescription(book.getDescription());
     bookSchema.setPublishDate(book.getPublishDate());
     bookSchema.setName(book.getName());
     bookSchema.setPrice(book.getPrice());
     return bookSchema;
  }
}
