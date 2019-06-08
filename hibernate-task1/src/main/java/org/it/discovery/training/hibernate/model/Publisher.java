package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Book publisher
 * @author morenets
 *
 */
@Getter @Setter
public class Publisher extends BaseEntity{
	private String name;
	
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
}
