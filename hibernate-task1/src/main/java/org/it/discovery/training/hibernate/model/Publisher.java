package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Book publisher
 * @author morenets
 *
 */
@Getter @Setter
@Entity
@Table(name = "PUBLISHER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Publisher extends BaseEntity{
	private String name;

	@OneToMany(mappedBy = "publisher")
	private List<Book> books;

	@Embedded
	private Address address;

	public List<Book> getBooks() {
		return books;
	}
}
