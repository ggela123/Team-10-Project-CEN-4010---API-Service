package com.group10.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> listAll() {
        return (List<Book>) repo.findAll();
    }

    public void save(Book book) {
        repo.save(book);
    }

    public Book get(Long id) throws BookNotFoundException {
        Optional<Book> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }
        throw new BookNotFoundException("Could not find any books with ID: " + id);
    }

    public void delete(Long id) throws BookNotFoundException {
        Long count =  repo.countById(id);
        if (count == null || count == 0) {
            throw new BookNotFoundException("Could not find any books with ID: " + id);
        }
        repo.deleteById(id);
    }
}
