package com.hibernate.hibernate_masterclass.domain.usecases.books.commands;


import java.time.LocalDate; /**
 * @author Sawadogo hamed   email <kerb418@gmail.com>
 **/

public interface BaseBookResponseCommand {
    Long id();
    String name();
    String description();
    Double price();
    LocalDate publishDate();
}