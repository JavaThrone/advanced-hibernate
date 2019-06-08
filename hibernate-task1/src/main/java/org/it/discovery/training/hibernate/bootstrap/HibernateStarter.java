package org.it.discovery.training.hibernate.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.it.discovery.training.hibernate.repository.hibernate.HibernateBookRepository;
import org.it.discovery.training.hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class HibernateStarter {

    public static void main(String[] args) {
        Session session = null;
        try (SessionFactory factory = HibernateUtil.getSessionFactory()) {

            session = factory.getCurrentSession();
            session.beginTransaction();
            // Persistent operations
            Person person = new Person();
            person.setName("Gaving King");
            Book book = new Book();
            book.setName("Hibernate 3");
            book.setAuthor(person);
            book.setHits(new ArrayList<>());
            Hit hit = new Hit();
            hit.setBook(book);
            book.getHits().add(hit);
            session.persist(book);
            System.out.println(book.getId());
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Book book2 = session.load(Book.class, book.getId());
//            book2.setName("Gavin King++");
            List<Book> books = session.createNamedQuery(Book.FIND_BY_NAME,
                    Book.class).setParameter("name", "test")
                    .getResultList();

            session.getTransaction().commit();
            BookRepository bookRepository = new HibernateBookRepository(factory);
            books = bookRepository.findAll();
            System.out.println("Books=" + books);

            books = bookRepository.findWithName("Hibernate 3");
            System.out.println("Books with name =" + books);

            books = bookRepository.findWithHits();
            System.out.println("Books with hits =" + books);
            session = factory.getCurrentSession();
            session.beginTransaction();
            Publisher publisher = new Publisher();
            publisher.setName("Apress");
            session.save(publisher);
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Publisher publisher2 = session.get(Publisher.class, publisher.getId());
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        }

    }

}
