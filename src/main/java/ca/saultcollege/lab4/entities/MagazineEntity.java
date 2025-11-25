package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("MAGAZINE")
public class MagazineEntity extends PublicationEntity {

    @Column(name = "order_qty")
    private int orderQty;


    @Column(name = "current_issue")
    private LocalDate currentIssue;

    public MagazineEntity() {
    }

    public MagazineEntity(String title, double price, int copies,int orderQty, LocalDate currentIssue) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public LocalDate getCurrentIssue() {
        return currentIssue;
    }

    public void setCurrentIssue(LocalDate currentIssue) {
        this.currentIssue = currentIssue;
    }







    @Override
    public String toString() {
        return "MagazineEntity{" +
                "orderQty=" + orderQty +
                ", currentIssue=" + currentIssue +
                "} " + super.toString();
    }


}