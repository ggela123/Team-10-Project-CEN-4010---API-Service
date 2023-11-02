package team0.bookratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





import team0.bookratings.model.BookratingsApplication;
import team0.bookratings.service.bookService;

    @RestController

    @RequestMapping("/api")
    public class bookratingcontroller {
        @Autowired
        bookService bookService;



        @RequestMapping(value="/Book Rating", method=RequestMethod.POST)
        public BookratingsApplication createrating(@RequestBody BookratingsApplication ratings) {
            return bookService.createrating(ratings); }


        @RequestMapping(value="/ratings", method=RequestMethod.GET)
        public List<BookratingsApplication>getrating() {
                return bookService.getrating();}

        @RequestMapping(value = "/ratings/{rating}", method = RequestMethod.PUT)
                public BookratingsApplication readratings (@PathVariable(value = "rating") Long ISBN, @RequestBody BookratingsApplication ratingDetails)
                {
                    return bookService.updaterating(ISBN, ratingDetails);
                }

                @RequestMapping(value = "/ratings/{rating}", method = RequestMethod.DELETE)
                public void deleteEmployees (@PathVariable(value = "rating") Long ISBN){
                    bookService.deleterating(ISBN);
                }

            }
