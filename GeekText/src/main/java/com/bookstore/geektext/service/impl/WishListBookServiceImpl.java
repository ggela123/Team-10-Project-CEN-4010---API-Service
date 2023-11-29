package com.bookstore.geektext.service.impl;

import com.bookstore.geektext.ResourceNotFoundException;
import com.bookstore.geektext.entity.Book;
import com.bookstore.geektext.entity.WishList;
import com.bookstore.geektext.entity.WishListBook;
import com.bookstore.geektext.repository.BookRepository;
import com.bookstore.geektext.repository.WishListBookRepository;
import com.bookstore.geektext.repository.WishListRepository;
import com.bookstore.geektext.service.WishListBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListBookServiceImpl implements WishListBookService {

    private final WishListBookRepository wishListBookRepository;
    private final BookRepository bookRepository;
    private final WishListRepository wishListRepository;

    @Autowired
    public WishListBookServiceImpl(WishListBookRepository wishListBookRepository,
                                   BookRepository bookRepository,
                                   WishListRepository wishListRepository) {
        this.wishListBookRepository = wishListBookRepository;
        this.bookRepository = bookRepository;
        this.wishListRepository = wishListRepository;
    }

    @Override
    public List<WishListBook> getAllWishListBooks() {
        return wishListBookRepository.findAll();
    }

    @Override
    public WishListBook getWishListBookById(Long id) {
        return wishListBookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WishListBook not found with id: " + id));
    }

    @Override
    public WishListBook createWishListBook(WishListBook wishListBook) {
        return wishListBookRepository.save(wishListBook);
    }

    @Override
    public WishListBook updateWishListBook(Long id, WishListBook updatedWishListBook) {
        WishListBook existingWishListBook = getWishListBookById(id);

        // Update properties of the existing WishListBook
        existingWishListBook.setBook(updatedWishListBook.getBook());
        existingWishListBook.setWishList(updatedWishListBook.getWishList());

        return wishListBookRepository.save(existingWishListBook);
    }

    @Override
    public WishListBook addToWishList(Long bookId, Long wishlistId) {
        if (bookId == null || wishlistId == null) {
            // Handle the case where bookId or wishlistId is null.
            throw new IllegalArgumentException("BookId and WishlistId must not be null");
        }

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        WishList wishList = wishListRepository.findById(wishlistId)
                .orElseThrow(() -> new ResourceNotFoundException("WishList not found with id: " + wishlistId));

        WishListBook wishListBook = new WishListBook();
        wishListBook.setBook(book);
        wishListBook.setWishList(wishList);

        return wishListBookRepository.save(wishListBook);
    }

    @Override
    public void deleteWishListBook(Long id) {
        wishListBookRepository.deleteById(id);
    }

    @Override
    public void removeFromWishList(Long wishListId, Long bookId) {
        WishList wishList = wishListRepository.findById(wishListId)
                .orElseThrow(() -> new ResourceNotFoundException("WishList not found with id: " + wishListId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        WishListBook wishListBook = wishListBookRepository.findByWishListAndBook(wishList, book);
        if (wishListBook != null) {
            wishListBookRepository.delete(wishListBook);
        }
    }
}

