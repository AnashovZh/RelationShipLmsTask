package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.repository.BookRepository;

import java.util.HashMap;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveBook(Book book, Long authorId) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, authorId);
        book.setAuthor(author);
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved BOOK";
    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        book.setAuthor(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully update book author";
    }

    @Override
    public Map<Book,Publisher> getBookAndPublisherByBookId(Long bookId) {
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        Publisher publisher = book.getPublisher();
        Map<Book,Publisher>map=new HashMap<>();
        map.put(book,publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return map;
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        return null;
    }
}
