package ca.saultcollege.lab4.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK") // 1. Specifies the value for this subclass in the discriminator column
public class BookEntity extends PublicationEntity {

    private String author;


    // Note: The 'price' field is removed as it's inherited from Product

    public BookEntity() {
        super();
    }

    public BookEntity(String title, double price, int copies, String author) {
        super(title, price, copies); // Call the parent constructor
        this.author = author;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }




    @Override
    public String toString() {
        return "Book{" +
                " author='" + author + '\'' +
                ", title='" + getTitle() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", copies='" + getCopies() + '\'' +
                "} " + super.toString();
    }
}