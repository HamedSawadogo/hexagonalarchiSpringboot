package com.hibernate.hibernate_masterclass.domain.models.book;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private Long id;
  private String name;
  private String description;
  private Double price;
  private LocalDate publishDate;
}
