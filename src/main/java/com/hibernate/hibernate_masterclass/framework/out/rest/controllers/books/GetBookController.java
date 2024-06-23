package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books;

import com.hibernate.hibernate_masterclass.common.mappers.BookMapper;
import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GetBookController {

    private final BookJpaRepository bookJpaRepository;
    private final BookMapper bookMapper;

    @GetMapping(Uris.BASE_URL + Uris.BOOKS + Uris.ID)
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
       BookSchema book = bookJpaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("we canot find book with id %s", id)
        ));
       return ResponseEntity.ok().body(bookMapper.toModel(book));
    }
}
