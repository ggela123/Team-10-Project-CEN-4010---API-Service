package com.bookstore.geektext.service;

import com.bookstore.geektext.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Long id, Book updatedBook);
}
