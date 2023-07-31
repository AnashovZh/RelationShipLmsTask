package org.example;

import org.example.config.HibernateConfig;
import org.example.enums.Country;
import org.example.enums.Gender;
import org.example.enums.Genre;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.example.service.PublisherService;
import org.example.service.ReaderService;
import org.example.service.serviceImpl.AuthorServiceImpl;
import org.example.service.serviceImpl.BookServiceImpl;
import org.example.service.serviceImpl.PublisherServiceImpl;
import org.example.service.serviceImpl.ReaderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HibernateConfig.getEntityManager();
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        while (true) {
            switch (new Scanner(System.in).nextLine()) {
                case "1", "one" -> {          //*☺
                    System.out.println("Save publisher");
                    System.out.println("input publisher name");
                    String pName = new Scanner(System.in).nextLine();
                    System.out.println("input publisher address");
                    String pAddress = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.savePublisher(new Publisher(pName, pAddress)));
                }
                case "2", "two" -> {          //* ☺
                    System.out.println("get by id publisher ");
                    System.out.println(publisherService.getPublisherById(1L));
                }
                case "3", "three" -> {        //*☺
                    System.out.println("get all publishers");
                    System.out.println("asc or desc");
                    String ascOrDesc = new Scanner(System.in).nextLine();
                    publisherService.getAllPublishers(ascOrDesc).forEach(System.out::println);
                }
                case "4", "four" -> {         //*☺
                    System.out.println("update publisher ");
                    System.out.println("input publisher id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("input address publisher");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println("input name publisher ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.updatePublisher(id, new Publisher(address, name)));
                }
                case "5", "five" -> {         //☺
                    System.out.println("delete publisher ");
                    System.out.println("input publisher name");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(publisherService.deletePublisherByName(name));
                }
                case "6", "six" -> {          //☺
                    System.out.println("author save");
                    System.out.println("first name");
                    String f = new Scanner(System.in).nextLine();
                    System.out.println("last name");
                    String l = new Scanner(System.in).nextLine();
                    String e = new Scanner(System.in).nextLine();
                    System.out.println("date of birth");
                    System.out.println("year");
                    int y = new Scanner(System.in).nextInt();
                    System.out.println("month");
                    int m = new Scanner(System.in).nextInt();
                    System.out.println("day");
                    int day = new Scanner(System.in).nextInt();
                    System.out.println("country");
                    String c = new Scanner(System.in).nextLine();
                    System.out.println("gender");
                    String g = new Scanner(System.in).nextLine();
                    System.out.println(authorService.saveAuthor(new Author(f, l, e, LocalDate.of(y, m, day), Country.valueOf(c), Gender.valueOf(g))));
                }
                case "7", "seven" -> {            //☺
                    System.out.println("update author");
                    System.out.println(authorService.updateAuthor(1L, new Author("Li", "Bruce", "b@gmail.com", LocalDate.of(2020, 3, 3), Country.UK, Gender.MALE)));
                }
                case "8", "eight" -> {            //☺
                    System.out.println("get author by id");
                    System.out.println("input id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(authorService.getAuthorById(id));
                }
                case "9", "nine" -> {            //☺
                    System.out.println("get authors by publish id");
                    System.out.println("publish id");
                    Long pId = new Scanner(System.in).nextLong();
                    System.out.println(authorService.getAuthorsByPublisherId(pId));
                }
                case "10", "ten" -> {            //☺
                    System.out.println("delete author by id");
                    System.out.println("input author id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(authorService.deleteAuthorById(id));
                }
                case "11", "eleven" -> {         //☺
                    System.out.println("assign author to publisher ");
                    System.out.println("input author id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("input publisher id");
                    Long pId = new Scanner(System.in).nextLong();
                    System.out.println(authorService.assignAuthorToPublisher(id, pId));
                }
                case "12", "twelve" -> {       //☺
                    System.out.println("save book");
                    System.out.println("input name book");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("input book country ");
                    String country = new Scanner(System.in).nextLine();
                    System.out.println("input published year");
                    int year = new Scanner(System.in).nextInt();
                    System.out.println("input published month ");
                    int month = new Scanner(System.in).nextInt();
                    System.out.println("input published day");
                    int day = new Scanner(System.in).nextInt();
                    System.out.println("input book price ");
                    int price = new Scanner(System.in).nextInt();
                    System.out.println("input book genre");
                    String genre = new Scanner(System.in).nextLine();
                    Book book = new Book(name, Country.valueOf(country), LocalDate.of(year, month, day),
                            BigDecimal.valueOf(price), Genre.valueOf(genre));
                    System.out.println("input author id");
                    Long authorId = new Scanner(System.in).nextLong();
                    System.out.println(bookService.saveBook(book, authorId));

                }
                case "13", "thirteen" -> {
                    System.out.println("update book author");
                    System.out.println("input book id");
                    Long bookId = new Scanner(System.in).nextLong();
                    Author newAuthor = new Author("Aaly", "Tokombaev", "aa@gmail.com", LocalDate.of(2021, 2, 2), Country.UK, Gender.MALE);
                    System.out.println(bookService.updateBookAuthor(bookId, newAuthor));
                }
                case "14", "fourteen" -> {
                    System.out.println("get book and publisher by bookId");
                    System.out.println("input bookId");
                    Long bookId = new Scanner(System.in).nextLong();
                    System.out.println(bookService.getBookAndPublisherByBookId(bookId));
                }

            }
        }
    }
}
