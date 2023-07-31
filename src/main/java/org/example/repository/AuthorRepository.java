package org.example.repository;

import org.example.model.Author;

import java.util.List;

public interface AuthorRepository {

    String saveAuthor(Author author);
    String updateAuthor(Long id,Author author);
    Author getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long id);
    String deleteAuthorById(Long id);//автор очкондо, авторго тиешелуу издательство очпошу керек  китептер очуш керек
    String  assignAuthorToPublisher(Long authorId,Long publisherId);//авторду издательствого кошуп коюу назначить.

}
