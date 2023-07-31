package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.model.Author;
import org.example.model.Publisher;
import org.example.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {
    EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String saveAuthor(Author author) {
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved author ";
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        entityManager.getTransaction().begin();
        Author author1 = entityManager.find(Author.class, id);
        author1.setFirstName(author.getFirstName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());
        author1.setDateOfBirth(author.getDateOfBirth());
        author1.setCountry(author.getCountry());
        author1.setGender(author.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully update author ";
    }

    @Override
    public Author getAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return author;
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long id) {
        entityManager.getTransaction().begin();
        List<Author> resultList = entityManager.createQuery("select a from Author a join a.publishers" +
        " p where p.id=:n ", Author.class).setParameter("n", id).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public String deleteAuthorById(Long id) {
        entityManager.getTransaction().begin();
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted author ";
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        entityManager.getTransaction().begin();
        List<Publisher>publishers=new ArrayList<>();
        List<Author>authors=new ArrayList<>();
        Author author = entityManager.find(Author.class, authorId);
        Publisher publisher1 = entityManager.find(Publisher.class, publisherId);
        publishers.add(publisher1);
        authors.add(author);
        author.setPublishers(publishers);
        publisher1.setAuthors(authors);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully assigned author to publisher";

    }
}
