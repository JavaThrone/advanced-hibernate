package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseEntity {
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;

	public int getId() {
		return id;
	}
	
}
