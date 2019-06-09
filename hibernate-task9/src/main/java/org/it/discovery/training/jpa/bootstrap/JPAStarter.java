package org.it.discovery.training.jpa.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class JPAStarter {

	public static void main(String[] args) {
		var emf = Persistence.createEntityManagerFactory("library");
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
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

			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (em != null) {
				em.getTransaction().rollback();
			}
		} finally {
			 em.close();
			 emf.close();
		}

	}

}
