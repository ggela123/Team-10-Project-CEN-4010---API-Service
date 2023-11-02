package com.group10.book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Long countById(Integer id);
}
