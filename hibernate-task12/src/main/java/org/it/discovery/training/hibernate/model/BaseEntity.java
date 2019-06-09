package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class BaseEntity {
	@Id
	@GeneratedValue
	//@GeneratedValue(generator = "counter")
	//@GenericGenerator(name="counter", strategy = "org.it.discovery.training.hibernate.generator.AutoIncrementIdentifierGenerator")
	private UUID id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

}
