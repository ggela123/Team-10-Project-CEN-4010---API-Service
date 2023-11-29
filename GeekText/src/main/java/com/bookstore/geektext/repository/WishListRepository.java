package com.bookstore.geektext.repository;

import com.bookstore.geektext.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
