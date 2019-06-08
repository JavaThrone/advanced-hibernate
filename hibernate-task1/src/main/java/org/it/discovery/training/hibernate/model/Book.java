package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter @Setter
@Entity
@Table(name = "BOOK")
@NamedQuery(name = Book.FIND_ALL, query = "FROM Book")
@NamedQuery(name = Book.FIND_BY_NAME, query = "FROM Book WHERE name=:name")
@NamedQuery(name = Book.FIND_WITH_HITS,
		query = "FROM Book b inner join fetch b.hits h WHERE size(h) > 1")
@DiscriminatorValue("b")
public class Book extends BaseEntity {
	public static final String FIND_ALL = "Book.findAll";

	public static final String FIND_BY_NAME = "Book.findByName";

	public static final String FIND_WITH_HITS = "Book.findWithHits";

	@Column(name = "NAME", nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID",nullable = false)
	private Person author;

	@ManyToOne
	@JoinColumn(name = "PUBLISHER_ID")
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Hit> hits;

	public Person getAuthor() {
		return author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public List<Hit> getHits() {
		return hits;
	}
}
