package org.it.discovery.training.hibernate.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	public List<Book> getBooks() {
		return books;
	}
}
