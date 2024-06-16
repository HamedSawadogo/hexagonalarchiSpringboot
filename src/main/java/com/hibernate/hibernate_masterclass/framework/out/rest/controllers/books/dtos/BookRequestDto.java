package com.hibernate.hibernate_masterclass.framework.out.rest.controllers.books.dtos;

import com.hibernate.hibernate_masterclass.domain.usecases.books.commands.BaseBookRequestCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

/**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/
@Builder
public record BookRequestDto (
        @NotBlank
        String name,
        @NotBlank
        String description,
        @Positive
        Double price,
        String imageUrl
) implements BaseBookRequestCommand {

}
