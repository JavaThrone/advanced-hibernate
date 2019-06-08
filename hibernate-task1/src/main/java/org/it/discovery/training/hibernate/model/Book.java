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
public class Book extends BaseEntity {
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
