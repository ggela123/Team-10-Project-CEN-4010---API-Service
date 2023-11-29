package com.bookstore.geektext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bookstore.geektext", "com.bookstore.geektext.service"})
public class GeekTextApplication {

    public static void main(String[] args) {

        SpringApplication.run(GeekTextApplication.class, args);
    }

}
