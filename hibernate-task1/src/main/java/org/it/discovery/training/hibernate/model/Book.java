package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter @Setter
@Entity
public class Book extends BaseEntity {
	private String name;

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
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

	@OneToMany(mappedBy = "book")
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
