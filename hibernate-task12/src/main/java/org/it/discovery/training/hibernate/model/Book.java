package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.hibernate.ogm.datastore.document.options.AssociationStorage;
import org.hibernate.ogm.datastore.document.options.AssociationStorageType;

import javax.persistence.*;
import java.util.List;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter @Setter @ToString(exclude = "hits")
@Entity
@Table
@NamedQuery(name = Book.FIND_ALL, query = "FROM Book")
@NamedQuery(name = Book.FIND_BY_NAME, query = "FROM Book WHERE name=:name")
@NamedQuery(name = Book.FIND_WITH_HITS,
		query = "FROM Book b inner join fetch b.hits h WHERE size(h) > 1")
public class Book extends BaseEntity {
	public static final String FIND_ALL = "Book.findAll";

	public static final String FIND_BY_NAME = "Book.findByName";

	public static final String FIND_WITH_HITS = "Book.findWithHits";

	@Column(nullable = false)
	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(nullable = false)
	private Person author;

	@ManyToOne
	@JoinColumn
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int totalPages;

	//@Formula("(SELECT count(h.id) FROM HIT h where h.BOOK_ID = id)")
	private int hitCount;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@AssociationStorage(AssociationStorageType.IN_ENTITY)
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
