package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.CHAR)
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
