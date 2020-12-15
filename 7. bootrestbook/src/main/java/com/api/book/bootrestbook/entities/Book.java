package com.api.book.bootrestbook.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")   // Changes the name of Table from : book -> books
public class Book {
    @Id         // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.AUTO)    // AUTO INCREMENT in sql
    @Column(name = "book_id")     // change the name of our column
    private int id;

    // This makes author an foreign Key and first author data is saved then Book data is saved
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private String title;

    public Book() {
    }

    public Book(int id, Author author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
