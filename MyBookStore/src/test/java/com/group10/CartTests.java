package com.group10;

import com.group10.book.Book;
import com.group10.cart.CartItem;
import com.group10.cart.CartItemRepository;
import com.group10.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace =  AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CartTests {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddOneCartItem() {
        Book book = entityManager.find(Book.class, 1);
        User user = entityManager.find(User.class, 8);

        CartItem newItem = new CartItem();
        newItem.setUser(user);
        newItem.setBook(book);
        newItem.setQuantity(3);

        CartItem saveCartItem = cartRepo.save(newItem);

        assertTrue(saveCartItem.getId() > 0);
    }

    @Test
    public void testGetCartItemsByUser() {
        User user = new User();
        user.setId(7);

        List<CartItem> cartItems = cartRepo.findByUser(user);

        assertEquals(2,cartItems.size());
    }
}
