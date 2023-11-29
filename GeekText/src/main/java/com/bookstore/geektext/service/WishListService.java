package com.bookstore.geektext.service;

import com.bookstore.geektext.entity.Book;
import com.bookstore.geektext.entity.WishList;

import java.util.List;
public interface WishListService {
    List<WishList> getAllWishLists();
    WishList getWishListById(Long id);
    WishList createWishList(Long userId, String wishlistName);
    void deleteWishList(Long id);
    WishList updateWishList(Long id, WishList updatedWishList);
    List<Book> getBooksInWishlist(Long wishlistId);
}
