package com.group10.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getCurrentlyLoggedInUser(Authentication authentication) {
        if (authentication == null) { return null; }

        User user = null;
        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            String email = ((CustomUserDetails) principal).getUsername();
            user = userRepo.findByEmail(email);
        }

        return user;
    }
}
