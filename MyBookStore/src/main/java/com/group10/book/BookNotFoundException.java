package com.group10.book;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(String message) {
        super(message);
    }
}
