package team0.bookratings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book Rating")
public class BookratingsApplication {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) */

    @Column(name = "ISBN")
    private Long ISBN;

    @Column(name = "username")
    private String username;

    @Column(name = "rating out of 5")
    private Long rating ;

    /*  foreign keys from book and user class
    @ManyToOne
    @JoinColumn(name = "ISBN")
    private ISBN ISBN;

    @ManyToOne
    @JoinColumn(name = "username")
    private User username;

     */

    // Getter
    public Long getISBN() {
        return ISBN;
    }

    public String getusername() {
        return username;
    }

    public Long getrating() {
        return rating;
    }


    // Setter
    public void setISBN( long newISBN) {
        this.ISBN = newISBN;

    }

    public void setusername(String newusername) {
        this.username = newusername;

    }

    public void setrating(Long newrating) {
        this.rating = newrating;

    }


}