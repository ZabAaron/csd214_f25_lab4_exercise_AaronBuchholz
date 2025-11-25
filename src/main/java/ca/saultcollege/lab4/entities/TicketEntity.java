package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TICKET")
public class TicketEntity extends ProductEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;



    @Column(name = "description")
    private String description;

    public TicketEntity() {
    }

    public TicketEntity(String title, double price, String description) {
        super();
        this.title = title;
        this.price = price;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "TicketEntity{" +
                "title='" + title + '\'' +
                ", price=" + price +

                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}