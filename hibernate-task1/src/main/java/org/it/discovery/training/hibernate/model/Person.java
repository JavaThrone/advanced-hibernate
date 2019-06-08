package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Getter @Setter
public class Person extends BaseEntity {
	private String name;
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
}
