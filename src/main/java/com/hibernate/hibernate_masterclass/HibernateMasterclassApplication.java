package com.hibernate.hibernate_masterclass;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hibernate.hibernate_masterclass.domain.models.book.Book;
import com.hibernate.hibernate_masterclass.framework.in.jpa.repositories.BookJpaRepository;
import com.hibernate.hibernate_masterclass.framework.in.jpa.schemas.BookSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Map;

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
            //book.setPublishDate(LocalDate.of(2023, 1, 2));

            ObjectMapper objectMapper = new ObjectMapper();
            System.err.println(objectMapper.writeValueAsString(book));

            System.err.println("============*******************==============");
            String bookJson = "{\"id\":1,\"name\":\"book name\",\"description\":\"book description\",\"price\":650.0}";
            System.err.println(objectMapper.readValue(bookJson, Book.class));
           // System.err.println(objectMapper.readValue(bookJson, Map.class));

            System.err.println("============MAP============================");
            String jsonMap =  "{\"name\":\"tom\",\"email\":\"tom@gmail.com\"}";
           Map<String, Object> res = objectMapper.readValue(jsonMap, Map.class);
           System.err.println(res);
            System.err.println(res.entrySet());
            for (Map.Entry<String, Object> entry : res.entrySet()) {
                System.err.println(entry.getKey() + ": " + entry.getValue());
            }
//           res.getColumns().forEach(column -> System.err.println(column));

        };
    }

}
