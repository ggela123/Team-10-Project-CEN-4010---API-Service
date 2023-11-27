package com.group10.cart;

import com.group10.user.User;
import com.group10.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("/cart/add/{bid}/{qty}")
    public String addProductToCart(@PathVariable("bid") Long bookId,
                                   @PathVariable("qty") Integer quantity,
                                    Authentication authentication) {
        if (authentication == null ) {
            return "You must login to add this book to your shopping cart.";
        }

        User user = userService.getCurrentlyLoggedInUser(authentication);

        if (user == null) {
            return "You must login to add this book to your shopping cart.";
        }

        Integer addedQuantity = cartService.addBook(bookId, quantity, user);

        return addedQuantity + " copies of this book were added to your shopping cart";

    }


    @PostMapping("/cart/update/{bid}/{qty}")
    public String updateQuantity(@PathVariable("bid") Long bookId,
                                   @PathVariable("qty") Integer quantity,
                                   Authentication authentication) {
        if (authentication == null ) {
            return "You must login to update this book in your shopping cart.";
        }

        User user = userService.getCurrentlyLoggedInUser(authentication);

        if (user == null) {
            return "You must login to update this book in your shopping cart.";
        }

        float subtotal = cartService.updateQuantity(bookId, quantity, user);

        return String.valueOf(subtotal);

    }

    @PostMapping("/cart/remove/{bid}")
    public String removeBookFromCart(@PathVariable("bid") Long bookId,
                                 Authentication authentication) {
        if (authentication == null ) {
            return "You must login to remove this book from your shopping cart.";
        }

        User user = userService.getCurrentlyLoggedInUser(authentication);

        if (user == null) {
            return "You must login to remove this book from your shopping cart.";
        }

        cartService.removeBook(bookId, user);

        return "The product has been removed from your shopping cart.";

    }

}
