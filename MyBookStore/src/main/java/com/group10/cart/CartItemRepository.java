package com.group10.cart;

import com.group10.book.Book;
import com.group10.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    public List<CartItem> findByUser(User user);

    public CartItem findByUserAndBook(User user, Book book);

    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE c.book.id = ?2 "
            + "AND c.user.id = ?3")
    @Modifying
    public void updateQuantity(Integer quantity, Long bookID, Long userId);

    @Query("DELETE FROM CartItem c WHERE c.user.id = ?1 AND c.book.id = ?2")
    @Modifying
    public void deleteByUserAndBook(Long userId, Long bookId);

}
