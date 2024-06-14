package com.hibernate.hibernate_masterclass.domain.usecases.books;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.models.book.gateway.BookGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Service
@RequiredArgsConstructor
public class GetBooksUseCase {

    private final BookGateway bookGateway;

    public Page<Book> execute(int page, int size) {
        return bookGateway.findAll(page, size);
    }
}
