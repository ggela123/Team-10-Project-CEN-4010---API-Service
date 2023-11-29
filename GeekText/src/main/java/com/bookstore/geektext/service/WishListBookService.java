package com.bookstore.geektext.service;

import com.bookstore.geektext.entity.WishListBook;

import java.util.List;

public interface WishListBookService {
    List<WishListBook> getAllWishListBooks();
    WishListBook addToWishList(Long bookId, Long wishlistId);
    void deleteWishListBook(Long id);
    void removeFromWishList(Long wishListId, Long bookId);
    WishListBook getWishListBookById(Long id);
    WishListBook createWishListBook(WishListBook wishListBook);
    WishListBook updateWishListBook(Long id, WishListBook updatedWishListBook);
}
