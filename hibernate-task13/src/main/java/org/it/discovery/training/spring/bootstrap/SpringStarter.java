package org.it.discovery.training.spring.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.service.BookService;
import org.it.discovery.training.spring.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class SpringStarter {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(
                             PersistenceConfig.class)) {
            BookRepository bookRepository = context.getBean(BookRepository.class);

            Person person = new Person();
            person.setName("Gavin King");
            Book book = new Book();
            book.setName("Hibernate 3");
            book.setTotalPages(200);
            book.setAuthor(person);
            book.setHits(new ArrayList<>());
            Hit hit = new Hit();
            hit.setBook(book);
            book.getHits().add(hit);
            bookRepository.save(book);
            System.out.println("Books = " + bookRepository.findAll());
            System.out.println("Books with name JPA = " + bookRepository.findByName("JPA"));
            System.out.println("Books with pages > 100 = " +
                    bookRepository.findByTotalPagesGreaterThan(100));
            System.out.println("Book names " +
                    bookRepository.findDTOBy());

            BookService bookService = context.getBean(BookService.class);
            System.out.println("Books with name Hibernate 3 = " + bookService.findByName("Hibernate 3"));

        }
    }

}
