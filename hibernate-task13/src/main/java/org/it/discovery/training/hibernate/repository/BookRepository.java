package org.it.discovery.training.hibernate.repository;

import org.it.discovery.training.hibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Returns all the existing books
     *
     * @return
     */
    List<Book> findAll();

    /**
     * Returns all the books with exact name
     *
     * @param name
     * @return
     */
    List<Book> findByName(@Param("name") String name);

//    /**
//     * Returns all the books where name contains specified text
//     *
//     * @param name
//     * @return
//     */
//    List<Book> findLikeName(String name);

//    /**
//     * Returns all the books where number of totalPages is greater than totalPages parameter
//     *
//     * @param pages
//     * @return
//     */
//    List<Book> findWithMorePages(int pages);
//
//    /**
//     * Returns all the books with specified name or totalPages.
//     * Both parameters are optional. If name is null or totalPages = 0 we should
//     * ignore them
//     *
//     * @param name
//     * @param pages
//     * @return
//     */
//    List<Book> searchBooks(String name, int pages);
//
//    /**
//     * Returns overall number of totalPages for all the books
//     *
//     * @return
//     */
//    int findTotalPages();
//
//    /**
//     * Returns all the books sorted by name
//     *
//     * @return
//     */
//    List<Book> findSortedBooks();
}
