package com.bookstore.geektext.request;

public class WishListRequest {
    private Long userId;
    private String name;

    // Constructors (default and parameterized)

    public WishListRequest() {
        // Default constructor
    }

    public WishListRequest(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() method (optional)

    @Override
    public String toString() {
        return "WishListRequest{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
