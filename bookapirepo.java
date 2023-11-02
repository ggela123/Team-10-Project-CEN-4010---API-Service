package team0.bookratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team0.bookratings.model.BookratingsApplication;

@Repository
public interface bookapirepo extends JpaRepository<BookratingsApplication, Long> {

}