package com.bookstore.geektext.request;

public class WishlistBookRequest {

    private Long userId;
    private Long wishlistId;
    private Long bookId;
    private String wishlistName;

    // Constructors, getters, and setters

    public WishlistBookRequest() {
    }

    public WishlistBookRequest(Long userId, Long wishlistId, Long bookId) {
        this.userId = userId;
        this.wishlistId = wishlistId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }
}
