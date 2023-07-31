package org.example.service.serviceImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.repository.BookRepository;
import org.example.repository.repositoryImpl.BookRepositoryImpl;
import org.example.service.BookService;

import java.util.Map;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository=new BookRepositoryImpl();
    EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveBook(Book book,Long authorId) {
//        entityManager.getTransaction().begin();
//        Author author = entityManager.find(Author.class, authorId);
//        book.setAuthor(author);
//        entityManager.persist(book);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return bookRepository.saveBook(book,authorId );
    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        return bookRepository.updateBookAuthor(bookId,author);
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId) {
        return bookRepository.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        return bookRepository.deleteBookByAuthorId(authorId);
    }
}
