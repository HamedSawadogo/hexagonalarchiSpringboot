package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos;

import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BaseBookRequestCommand;
import lombok.Builder;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Builder
public record BookRequestDto (
        String name,
        String description,
        Double price
) implements BaseBookRequestCommand {

}
