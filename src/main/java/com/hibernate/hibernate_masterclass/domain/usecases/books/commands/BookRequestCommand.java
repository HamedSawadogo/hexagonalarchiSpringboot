package com.hibernate.hibernate_masterclass.domain.usecases.books.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestCommand {
  private String name;
  private String description;
  private Double price;

}
