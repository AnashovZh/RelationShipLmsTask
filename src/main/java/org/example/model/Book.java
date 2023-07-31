package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Country;
import org.example.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter@Setter
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_gen")
    @SequenceGenerator(name = "book_gen",sequenceName = "book_seg",
    allocationSize = 1)
    private Long id;
    private String name;
    private Country country;
    @Column(name = "published_year")
    private LocalDate publishedYear;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @OneToOne (mappedBy = "book", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH})
    private Reader reader;
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH})
    private Publisher publisher;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;

    public Book(Long id, String name, Country country, LocalDate publishedYear,
        BigDecimal price, Genre genre, Reader reader, Publisher publisher, Author author) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.reader = reader;
        this.publisher = publisher;
        this.author = author;
    }

    public Book(String name, Country country, LocalDate publishedYear,
     BigDecimal price, Genre genre,  Publisher publisher) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Book(String name, Country country, LocalDate publishedYear, BigDecimal price, Genre genre) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    public Book(String name, Country country, LocalDate publishedYear, BigDecimal price, Genre genre, Author author) {
        this.name = name;
        this.country = country;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
        this.author = author;
    }
}
