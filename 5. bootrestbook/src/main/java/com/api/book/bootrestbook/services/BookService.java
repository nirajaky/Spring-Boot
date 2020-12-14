package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//********************DUMMY CLASS****************************
@Component
public class BookService {
    private static List<Book> list = new ArrayList<Book>();

    // since static data is saved before Object creation
    static {
        list.add(new Book(2011, "Niraj", "Why"));
        list.add(new Book(5245, "Sonu", "When"));
        list.add(new Book(45, "Ankit", "Give"));
        list.add(new Book(42, "Jeetu", "Run"));
        list.add(new Book(572, "Sam", "Hahaha"));
    }
    // get all books
    public List<Book> getBooks(){
        return list;
    }

    // get book by id
    public Book getBookById(int id){
        Book book1 = null;
        book1 = list.stream().filter(e->{
            return e.getId()==id;
        }).findFirst().get();
        return book1;
    }

    // Add any book to our Server
    public Book addBook(Book book){
        list.add(book);
        return book;
    }

    // Delete book from our server
    public void deleteBook(int bookId){
        list = list.stream().filter(book-> book.getId() != bookId).collect(Collectors.toList());
    }

    //Update book from Book Server
    public void updateBook(Book book, int bookId){
        list = list.stream().map(book1 -> {
            if(book1.getId() == bookId){
                book1.setTitle(book.getTitle());
                book1.setAuthor((book.getAuthor()));
            }
            return book1;
        }).collect(Collectors.toList());
    }
}
