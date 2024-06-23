package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books;

import com.hibernate.hibernate_masterclass.common.dtos.response.PublicEntitiesPaginationResponse;
import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.domain.usecases.books.GetBooksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GetBooksController {
    private final GetBooksUseCase getBooksUseCase;

    @GetMapping(Uris.BASE_URL + Uris.BOOKS)
    public ResponseEntity<PublicEntitiesPaginationResponse<Book>> getBooks(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size
    ) {
        var books = getBooksUseCase.execute(page, size);
        var booksWithPagination = PublicEntitiesPaginationResponse.<Book>builder()
                .items(books.getContent())
                .limit(size)
                .page(page)
                .totalItems(books.getTotalElements())
                .totalPages(books.getTotalPages())
                .build();
        return ResponseEntity.ok().body(booksWithPagination);
    }
}
