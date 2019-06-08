package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter @Setter
@Embeddable
public class Address {

    private String city;

    private String street;

    private int apt;
}
