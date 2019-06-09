package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class BaseEntity {
	@Id
	@GeneratedValue(generator = "counter")
	@GenericGenerator(name="counter", strategy = "org.it.discovery.training.hibernate.generator.AutoIncrementIdentifierGenerator")
	private Integer id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;


}
