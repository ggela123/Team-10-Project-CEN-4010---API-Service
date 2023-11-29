package com.bookstore.geektext.repository;

import com.bookstore.geektext.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
