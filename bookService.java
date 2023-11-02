package team0.bookratings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team0.bookratings.model.BookratingsApplication;
import team0.bookratings.repository.bookapirepo;
import java.util.List;

@Service
public class bookService {

    @Autowired
    bookapirepo bookapirepo;

    // CREATE
    public BookratingsApplication createrating(BookratingsApplication rating) {

        return bookapirepo.save(rating);
    }

    // READ
    public List<BookratingsApplication> getrating()  {
        return bookapirepo.findAll();
    }

    // DELETE
    public void deleterating(Long rating) {

        bookapirepo.deleteById(rating);
    }

    // UPDATE
    public BookratingsApplication updaterating(Long ISBN, BookratingsApplication ratingDetails) {
        BookratingsApplication rating = bookapirepo.findById(ISBN).get();
        rating.setISBN(ratingDetails.getISBN());
        rating.setusername(ratingDetails.getusername());
        rating.setrating(ratingDetails.getrating());

        return bookapirepo.save(rating);
    }
}


