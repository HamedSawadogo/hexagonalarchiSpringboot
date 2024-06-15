package com.hibernate.hibernate_masterclass.domain.usecases.books.commands;


public interface BaseBookRequestCommand {
  String name();
  String description();
  Double price();

}
