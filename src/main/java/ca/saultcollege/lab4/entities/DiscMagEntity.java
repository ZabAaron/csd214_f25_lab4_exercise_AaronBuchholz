package ca.saultcollege.lab4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("DISC_MAG")
public class DiscMagEntity extends MagazineEntity {

    @Column(name = "has_disc")
    private boolean hasDisc;

    public DiscMagEntity() {
    }

    public DiscMagEntity(String title, double price, int copies, int orderQty, LocalDate currentIssue, boolean hasDisc) {

        super(title, price, copies, orderQty, currentIssue);
        this.hasDisc = hasDisc;
    }

    public boolean isHasDisc() {
        return hasDisc;
    }

    public void setHasDisc(boolean hasDisc) {
        this.hasDisc = hasDisc;
    }



    @Override
    public String toString() {
        return "DiscMagEntity{" +
                "hasDisc=" + hasDisc +
                "} " + super.toString();
    }
}