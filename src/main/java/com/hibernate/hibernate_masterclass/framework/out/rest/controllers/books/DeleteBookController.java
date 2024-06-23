package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books;

import com.hibernate.hibernate_masterclass.common.uris.Uris;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import com.hibernate.hibernate_masterclass.framework.out.rest.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class DeleteBookController {

    private final BookJpaRepository bookJpaRepository;

    @DeleteMapping(Uris.BASE_URL + Uris.BOOKS + Uris.ID)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        var book = bookJpaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                String.format("Book with id %s not found", id)
        ));
        bookJpaRepository.delete(book);
        return ResponseEntity.ok().build();
    }
}
