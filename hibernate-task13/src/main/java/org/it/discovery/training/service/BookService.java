package org.it.discovery.training.service;

import org.it.discovery.training.hibernate.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void save(Book book);

    List<Book> findByName(String name);
	

}
