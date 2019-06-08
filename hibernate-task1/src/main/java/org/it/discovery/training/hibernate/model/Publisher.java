package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Book publisher
 * @author morenets
 *
 */
@Getter @Setter
@Entity
public class Publisher extends BaseEntity{
	private String name;

	@OneToMany(mappedBy = "publisher")
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
}
