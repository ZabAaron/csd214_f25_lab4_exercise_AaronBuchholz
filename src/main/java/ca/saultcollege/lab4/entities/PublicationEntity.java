package ca.saultcollege.lab4.entities;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "publication_type")
public abstract class PublicationEntity extends ProductEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "copies")
    private int copies;

    public PublicationEntity(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }


    @Override
    public String toString() {
        return "PublicationEntity{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                "} " + super.toString();
    }



    public PublicationEntity() {
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

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }



}