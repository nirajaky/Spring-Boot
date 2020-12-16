package com.api.book.bootrestbook.controllers;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //    @RequestMapping(value = "/books", method = RequestMethod.GET)
    //    @ResponseBody : Not needed when we use @RestController Annotation

    @Autowired
    private BookService bookService;

    //      READ*****************************************
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBook(){
        List<Book> list = bookService.getBooks();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
    // @PathVariable will capture any variable with name "id" from route path
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //      CREATE********************************************
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = bookService.addBook(book);
        return b;
    }

    //     DELETE**************************************
    // Here we can use ResponseEntity<Void>
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
