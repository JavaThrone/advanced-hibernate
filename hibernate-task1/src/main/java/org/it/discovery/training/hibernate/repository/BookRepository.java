package org.it.discovery.training.hibernate.repository;

import java.util.List;

import org.it.discovery.training.hibernate.model.Book;

public interface BookRepository {
	
	/**
	 * Returns all the existing books
	 * @return
	 */
	List<Book> findAll();
	
	/**
	 * Returns all the books with exact name
	 * @param name
	 * @return
	 */
	List<Book> findWithName(String name);

	/**
	 * Returns all the books that has at least two hits
	 * @return
	 */
	List<Book> findWithHits();

	/**
	 * Returns all the books where number of totalPages is greater than totalPages parameter
	 * @param pages
	 * @return
	 */
	List<Book> findWithMorePages(int pages);
	
	/**
	 * Returns all the books with specified name or totalPages.
	 * Both parameters are optional. If name is null or totalPages = 0 we should
	 * ignore them
	 * @param name
	 * @param pages
	 * @return
	 */
	List<Book> searchBooks(String name, int pages);
	
	/**
	 * Returns overall number of totalPages for all the books
	 * @return
	 */
	int findTotalPages();
	
	/**
	 * Returns all the books sorted by name
	 * @return
	 */
	List<Book> findSortedBooks();	
	
}
