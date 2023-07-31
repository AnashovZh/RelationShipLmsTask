package org.example.service.serviceImpl;

import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.example.repository.repositoryImpl.AuthorRepositoryImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository=new AuthorRepositoryImpl();
    @Override
    public String saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
        return authorRepository.updateAuthor(id,author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long id) {
        return authorRepository.getAuthorsByPublisherId(id);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id);
    }

    @Override
    public String assignAuthorToPublisher(Long authorId, Long publisherId) {
        return authorRepository.assignAuthorToPublisher(authorId,publisherId);
    }
}
