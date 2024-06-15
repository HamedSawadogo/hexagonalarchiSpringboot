package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos;

import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BaseBookResponseCommand;
import lombok.Builder;

import java.time.LocalDate;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Builder
public record PublicBookResponse(
        Long id,
        String name,
        String description,
        Double price,
        LocalDate publishDate
) implements BaseBookResponseCommand {
}
