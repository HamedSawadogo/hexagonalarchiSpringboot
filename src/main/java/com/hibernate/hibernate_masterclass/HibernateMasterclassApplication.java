package com.hibernate.hibernate_masterclass;

import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDate;

@SpringBootApplication
@EnableAsync
public class HibernateMasterclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateMasterclassApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookJpaRepository bookJpaRepository) {
        return args -> {
            BookSchema book = new BookSchema();
            book.setName("book name");
            book.setId(1L);
            book.setPrice(650d);
            book.setDescription("book description");
            book.setPublishDate(LocalDate.now());
            bookJpaRepository.save(book);

            BookSchema bookSchema = new BookSchema();
            bookSchema.setId(1L);
            bookSchema.setName("book schema name");
            bookSchema.setDescription("book schema description");
            bookSchema.setPublishDate(LocalDate.now());
            bookJpaRepository.save(bookSchema);
        };
    }

}
