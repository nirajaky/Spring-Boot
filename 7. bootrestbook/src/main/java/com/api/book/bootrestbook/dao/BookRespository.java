package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book, Integer> {
    public Book findById(int id);
}
