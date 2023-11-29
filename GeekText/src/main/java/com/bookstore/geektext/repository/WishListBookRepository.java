package com.bookstore.geektext.repository;

import com.bookstore.geektext.entity.Book;
import com.bookstore.geektext.entity.WishList;
import com.bookstore.geektext.entity.WishListBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListBookRepository extends JpaRepository<WishListBook, Long> {
    WishListBook findByWishListAndBook(WishList wishList, Book book);
}
