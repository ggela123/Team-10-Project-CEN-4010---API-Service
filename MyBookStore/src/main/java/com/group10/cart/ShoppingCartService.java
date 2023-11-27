package com.group10.cart;

import com.group10.book.Book;
import com.group10.book.BookRepository;
import com.group10.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private BookRepository bookRepo;

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }

    public Integer addBook(Long bookId, Integer quantity, User user) {
        Integer addedQuantity = quantity;

        Book book = bookRepo.findById(bookId).get();

        CartItem cartItem = cartRepo.findByUserAndBook(user, book);

        if (cartItem != null) {
            addedQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuantity);
        } else {
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setUser(user);
            cartItem.setBook(book);
        }

        cartRepo.save(cartItem);

        return addedQuantity;
    }

    public float updateQuantity(Long bookId, Integer quantity, User user) {
        cartRepo.updateQuantity(quantity, bookId, user.getId());
        Book book = bookRepo.findById(bookId).get();

        float subtotal = book.getPrice().floatValue() * quantity;
        return subtotal;
    }

    public void removeBook(Long bookId, User user) {
        cartRepo.deleteByUserAndBook(user.getId(), bookId);
    }
}
