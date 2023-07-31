package org.example.repository;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;

import java.util.Map;

public interface BookRepository {
    String  saveBook(Book book,Long authorId);//Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек
    String  updateBookAuthor(Long bookId, Author author);
    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookId);
    String deleteBookByAuthorId(Long authorId);
}
