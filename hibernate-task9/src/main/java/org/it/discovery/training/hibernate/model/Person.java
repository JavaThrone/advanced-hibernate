package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Person who can write books, for example
 * @author admin
 *
 */
@Getter @Setter @ToString(exclude = "books")
@Entity
@NamedQuery(name = Person.QUERY_PERSONS_WITHOUT_BOOKS,
query = "SELECT p FROM Person p WHERE p.books is empty")
public class Person extends BaseEntity {
	public static final String QUERY_PERSONS_WITHOUT_BOOKS = "Person.findWithoutBooks";

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
