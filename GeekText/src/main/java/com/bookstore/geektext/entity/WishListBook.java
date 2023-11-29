package com.bookstore.geektext.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlist_book")
public class WishListBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id", nullable = false)
    private WishList wishList;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    // Constructors

    public WishListBook() {
        // Default constructor
    }

    public WishListBook(WishList wishList, Book book) {
        this.wishList = wishList;
        this.book = book;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Additional methods or customizations can be added as needed
}
