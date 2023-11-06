package com.group10;

import com.group10.book.Book;
import com.group10.book.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BookRepositoryTests {
    @Autowired
    private BookRepository repo;

    @Test
    public void testAddNew() {
        Book book = new Book();
        book.setISBN("9780060244194");
        book.setAuthor("Shel Silverstein");
        book.setCopiesSold(121);
        book.setDescription("A tree's selfless love for a boy as it provides over the years, " +
                "ultimately sacrificing itself.");
        book.setGenre("Children's Literature");
        book.setName("The Giving Tree");
        book.setPrice(new BigDecimal(11.99));
        book.setPublisher("HarperCollins");
        book.setYearPublished(1964);

        Book savedBook =  repo.save(book);
        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<Book> books = repo.findAll();
        Assertions.assertThat(books).hasSizeGreaterThan(0);

        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testUpdate() {
        Integer bookId = 1;
        Optional<Book> optionalBook = repo.findById(bookId);
        Book book = optionalBook.get();
        Integer newValue = book.getCopiesSold() + 1;
        book.setCopiesSold(newValue);
        repo.save(book);

        Book updatedBook = repo.findById(bookId).get();
        Assertions.assertThat(updatedBook.getCopiesSold()).isEqualTo(newValue);
    }


    @Test
    public void testGet() {
        Integer bookId = 2;
        Optional<Book> optionalBook = repo.findById(bookId);
        Assertions.assertThat(optionalBook).isPresent();
        System.out.println(optionalBook.get());
    }

    @Test
    public void testDelete() {
        Integer bookId = 2;
        repo.deleteById(bookId);

        Optional<Book> optionalBook = repo.findById(bookId);
        Assertions.assertThat(optionalBook).isNotPresent();

    }

}
