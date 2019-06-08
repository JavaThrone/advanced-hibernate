package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Book in a library
 * @author morenets
 *
 */
@Getter @Setter
public class Book extends BaseEntity {
	private String name;
	
	private Person author;
	
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;
	
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
