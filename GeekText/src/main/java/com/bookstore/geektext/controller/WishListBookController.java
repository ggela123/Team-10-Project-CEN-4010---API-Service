package com.bookstore.geektext.controller;

import com.bookstore.geektext.entity.WishListBook;
import com.bookstore.geektext.request.WishlistBookRequest;
import com.bookstore.geektext.service.WishListBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist-books")
public class WishListBookController {

    private final WishListBookService wishListBookService;

    @Autowired
    public WishListBookController(WishListBookService wishListBookService) {
        this.wishListBookService = wishListBookService;
    }

    @GetMapping
    public ResponseEntity<List<WishListBook>> getAllWishListBooks() {
        List<WishListBook> wishListBooks = wishListBookService.getAllWishListBooks();
        return ResponseEntity.ok(wishListBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishListBook> getWishListBookById(@PathVariable Long id) {
        WishListBook wishListBook = wishListBookService.getWishListBookById(id);
        return ResponseEntity.ok(wishListBook);
    }

    @PostMapping
    public ResponseEntity<WishListBook> addBookToWishlist(@RequestBody WishlistBookRequest wishlistBookRequest) {
        Long bookId = wishlistBookRequest.getBookId();
        Long wishlistId = wishlistBookRequest.getWishlistId();

        WishListBook wishListBook = wishListBookService.addToWishList(bookId, wishlistId);
        return ResponseEntity.ok(wishListBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishListBook(@PathVariable Long id) {
        wishListBookService.deleteWishListBook(id);
        return ResponseEntity.noContent().build();
    }
}
