package org.it.discovery.training.hibernate.repository.jpql;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RequiredArgsConstructor
public class JPQLPersonRepository implements PersonRepository {
    private final EntityManagerFactory emf;

    @Override
    public List<Person> findPersonWithoutBooks() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.createNamedQuery(Person.QUERY_PERSONS_WITHOUT_BOOKS, Person.class)
                    .getResultList();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            em.close();
        }
    }

    @Override
    public Person findMostEfficientAuthor() {
        return null;
    }

    @Override
    public List<Person> findPersonsByBook(String name) {
        return null;
    }

    @Override
    public List<Person> findPersonsOfPublisher(int publisherId) {
        return null;
    }

    @Override
    public List<Person> findTopAuthors(int limit) {
        return null;
    }
}
