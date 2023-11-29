package com.bookstore.geektext.service.impl;

import com.bookstore.geektext.entity.WishList;
import com.bookstore.geektext.repository.WishListRepository;
import com.bookstore.geektext.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.geektext.entity.Book;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    private final WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public List<WishList> getAllWishLists() {
        return wishListRepository.findAll();
    }

    @Override
    public WishList getWishListById(Long id) {
        return wishListRepository.findById(id).orElse(null);
    }

    @Override
    public WishList createWishList(Long userId, String wishlistName) {
        // You need to implement the logic to create a new wishlist
        // and associate it with the user identified by userId.
        // This involves creating a new WishList instance, setting its properties,
        // and saving it to the database using wishListRepository.save().
        // I'm providing a basic example, and you may need to adjust it based on your requirements.

        WishList wishList = new WishList();
        wishList.setUserId(userId);
        wishList.setWishlistName(wishlistName);

        return wishListRepository.save(wishList);
    }

    @Override
    public List<Book> getBooksInWishlist(Long wishlistId) {
        // Implement the logic to retrieve books in the specified wishlist
        // You can use wishListRepository.findById(wishlistId) and extract books from the WishList entity.
        // Return the list of books.
        return null;  // Replace this with your implementation
    }

    @Override
    public void deleteWishList(Long id) {
        wishListRepository.deleteById(id);
    }

    @Override
    public WishList updateWishList(Long id, WishList updatedWishList) {
        // Similar to createWishList, you need to implement the logic to update an existing wishlist.
        // Fetch the existing wishlist by id, update its properties, and save it back to the database.
        // I'm providing a basic example, and you may need to adjust it based on your requirements.

        WishList existingWishList = wishListRepository.findById(id).orElse(null);

        if (existingWishList != null) {
            // Update properties of the existing wishlist
            existingWishList.setWishlistName(updatedWishList.getWishlistName());

            // Save the updated wishlist to the database
            return wishListRepository.save(existingWishList);
        } else {
            return null; // Handle the case where the wishlist with the given id is not found
        }
    }
}
