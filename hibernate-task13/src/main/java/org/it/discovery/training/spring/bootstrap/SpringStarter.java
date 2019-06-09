package org.it.discovery.training.spring.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.service.BookService;
import org.it.discovery.training.spring.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class SpringStarter {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(
                             PersistenceConfig.class)) {
            BookService bookService = context.getBean(BookService.class);

            Person person = new Person();
            person.setName("Gavin King");
            Book book = new Book();
            book.setName("Hibernate 3");
            book.setAuthor(person);
            book.setHits(new ArrayList<>());
            Hit hit = new Hit();
            hit.setBook(book);
            book.getHits().add(hit);
            bookService.save(book);
            System.out.println("Books = " + bookService.findAll());
        }
    }

}
