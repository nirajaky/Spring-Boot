package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    //    @RequestMapping(value = "/books", method = RequestMethod.GET)
    //    @ResponseBody : Not neede when we use @RestController Annotation

    @Autowired
    private BookService bookService;

    //      READ*****************************************
    @GetMapping("/books")
    public List<Book> getBook(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    // @PathVariable will capture any variable with name "id" from route path
    public Book getBookById(@PathVariable("id") int id){
        return this.bookService.getBookById(id);
    }

    //      CREATE********************************************
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = bookService.addBook(book);
        return b;
    }

    //     DELETE**************************************
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
    }

    //     UPDATE*******************************************
    @PutMapping("/books/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
        bookService.updateBook(book, bookId);
    }
}
