package com.hibernate.hibernate_masterclass.common.mappers;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BaseBookRequestCommand;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  public  Book toModel(BaseBookRequestCommand command) {
    Book book = new Book();
    book.setDescription(command.description());
    book.setName(command.name());
    book.setPrice(command.price());
    book.setImageUrl(command.imageUrl());
    book.setPublishDate(LocalDate.now());
    return book;
  }

  public  Book toModel(BookSchema bookSchema) {
    Book book = new Book();
    book.setId(bookSchema.getId());
    book.setDescription(bookSchema.getDescription());
    book.setName(bookSchema.getName());
    book.setPrice(bookSchema.getPrice());
    book.setPublishDate(bookSchema.getPublishDate());
    book.setImageUrl(bookSchema.getImageUrl());
    return book;
  }

  public  BookSchema toSchema(Book book) {
     BookSchema bookSchema = new BookSchema();
     bookSchema.setId(book.getId());
     bookSchema.setDescription(book.getDescription());
     bookSchema.setPublishDate(book.getPublishDate());
     bookSchema.setName(book.getName());
     bookSchema.setPrice(book.getPrice());
     bookSchema.setImageUrl(book.getImageUrl());
     return bookSchema;
  }
}
