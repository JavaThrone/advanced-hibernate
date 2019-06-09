package org.it.discovery.training.hibernate.ogm;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class MongoStarter {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("mongo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Person person = new Person();
		person.setName("Gavin King");
		Book book = new Book();
		book.setName("Hibernate 3");
		book.setAuthor(person);
		book.setHits(new ArrayList<>());
		Hit hit = new Hit();
		hit.setBook(book);
		book.getHits().add(hit);
		em.persist(book);
		Person developer = new Person();
		developer.setName("Sergey Morenets");
		em.persist(developer);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
