package com.hibernate.hibernate_masterclass.domain.models.book.gateway;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;

public interface BookGateway {
   Book create(Book book);
}
