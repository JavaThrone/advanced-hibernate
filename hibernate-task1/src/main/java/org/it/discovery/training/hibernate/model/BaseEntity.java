package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(generator = "counter")
	@GenericGenerator(name="counter", strategy = "org.it.discovery.training.hibernate.generator.AutoIncrementIdentifierGenerator")
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

	public int getId() {
		return id;
	}
	
}
