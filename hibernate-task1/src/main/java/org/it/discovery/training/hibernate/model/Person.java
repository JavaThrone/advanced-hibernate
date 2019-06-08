package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Getter @Setter
@Entity
public class Person extends BaseEntity {
	private String name;
	
	/**
	 * Books that person has written
	 */
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
}
