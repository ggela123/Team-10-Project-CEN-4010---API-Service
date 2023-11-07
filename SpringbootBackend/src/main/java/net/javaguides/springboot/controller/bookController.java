package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.book;
import net.javaguides.springboot.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/book")
public class bookController {

    @Autowired
    private bookRepository bookRepository;

    @GetMapping
    public List<book> getAllBooks(){
        return bookRepository.findAll();
    }

    // build create book REST API
    @PostMapping
    public book createbook(@RequestBody book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<book> getbookById(@PathVariable  long id){
        book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(book);
    }

    // build update book REST API
    @PutMapping("{id}")
    public ResponseEntity<book> updateBook(@PathVariable long id,@RequestBody book bookDetails) {
        book updateBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateBook.setRating(bookDetails.getRating());
        updateBook.setComment(bookDetails.getComment());
        updateBook.setUserName(bookDetails.getUserName());
        updateBook.setISBN(bookDetails.getISBN());

        bookRepository.save(updateBook);

        return ResponseEntity.ok(updateBook);
    }

    // build delete book REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable long id){

        book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book does not exist with id: " + id));

        bookRepository.delete(book);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    }