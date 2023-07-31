package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "publisher_gen")
    @SequenceGenerator(name = "publisher_gen",
            sequenceName = "publisher_seg",
            allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @ManyToMany(mappedBy = "publishers",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH})
    private List<Author> authors;
    @OneToMany(mappedBy = "publisher",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REMOVE,
            CascadeType.REFRESH})
    private List<Book> books;

    public Publisher(Long id, String name, String address,
     List<Author> authors, List<Book> books) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.authors = authors;
        this.books = books;
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address ;
    }
}
