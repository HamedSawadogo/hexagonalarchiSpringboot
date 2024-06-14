package com.hibernate.hibernate_masterclass.domain.models.book.gateway;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import org.springframework.data.domain.Page;


public interface BookGateway {
   Book create(Book book);
   Page<Book> findAll(int page, int size);
}
