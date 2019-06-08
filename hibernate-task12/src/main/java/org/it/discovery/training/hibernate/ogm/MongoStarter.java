package org.it.discovery.training.hibernate.ogm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MongoStarter {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("mongo");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
