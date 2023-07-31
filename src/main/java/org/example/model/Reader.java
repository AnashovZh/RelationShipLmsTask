package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "readers")
@Getter@Setter
@NoArgsConstructor

public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reader_gen")
    @SequenceGenerator(name = "reader_gen",sequenceName = "reader_seg",allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate age;
    private String email;
    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH})
    private Book book;

    public Reader(Long id, String name, LocalDate age, String email, Book book) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.book = book;
    }
}
