package com.bookstore.geektext.controller;

import com.bookstore.geektext.entity.WishList;
import com.bookstore.geektext.request.WishlistBookRequest;
import com.bookstore.geektext.service.WishListService;
import com.bookstore.geektext.service.WishListBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookstore.geektext.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishListController {

    private final WishListService wishListService;
    private final WishListBookService wishListBookService;

    @Autowired
    public WishListController(WishListService wishListService, WishListBookService wishListBookService) {
        this.wishListService = wishListService;
        this.wishListBookService = wishListBookService;
    }

    @GetMapping
    public ResponseEntity<List<WishList>> getAllWishLists() {
        List<WishList> wishLists = wishListService.getAllWishLists();
        return ResponseEntity.ok(wishLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishList> getWishListById(@PathVariable Long id) {
        WishList wishList = wishListService.getWishListById(id);
        return ResponseEntity.ok(wishList);
    }



    @PostMapping("/create")
    public ResponseEntity<WishList> createWishlist(@RequestBody WishlistBookRequest wishlistBookRequest) {
        Long userId = wishlistBookRequest.getUserId();
        String wishlistName = wishlistBookRequest.getWishlistName();

        if (userId == null || wishlistName == null) {
            return ResponseEntity.badRequest().build();
        }

        WishList createdWishList = wishListService.createWishList(userId, wishlistName);
        return ResponseEntity.ok(createdWishList);
    }

    @PostMapping("/add-book")
    public ResponseEntity<WishList> addBookToWishlist(@RequestBody WishlistBookRequest wishlistBookRequest) {
        Long bookId = wishlistBookRequest.getBookId();
        Long wishlistId = wishlistBookRequest.getWishlistId();

        if (bookId == null || wishlistId == null) {
            return ResponseEntity.badRequest().build();
        }

        WishList updatedWishList = wishListBookService.addToWishList(bookId, wishlistId).getWishList();
        return ResponseEntity.ok(updatedWishList);
    }

    @DeleteMapping("/{id}/remove-book/{bookId}")
    public ResponseEntity<Void> removeBookFromWishlist(@PathVariable Long id, @PathVariable Long bookId) {
        wishListService.deleteWishList(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WishList> updateWishList(@PathVariable Long id, @RequestBody WishList updatedWishList) {
        WishList result = wishListService.updateWishList(id, updatedWishList);
        return ResponseEntity.ok(result);
    }
}
