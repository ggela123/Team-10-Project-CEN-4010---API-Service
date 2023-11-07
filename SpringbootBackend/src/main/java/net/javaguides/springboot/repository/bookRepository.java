package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface bookRepository extends JpaRepository<book, Long> {
    // all crud database methods
}
