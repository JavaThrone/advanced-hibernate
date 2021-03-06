package org.it.discovery.training.service;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DefaultBookService implements BookService {
	
	private final BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findByName(String name) {
		Book book = new Book();
		book.setName(name);
		Example<Book> example = Example.of(book);
		return bookRepository.findAll(example);
	}
}
