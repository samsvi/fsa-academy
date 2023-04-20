package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "rental", schema = "public")
@Access(AccessType.FIELD)
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long rentalId;

    @Column(name = "rental_date")
    private Date rentalDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customerRental;

    @Column(name = "return_date")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffRental;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "rentalPayment")
    private Set<Payment> payments;

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Customer getCustomerRental() {
        return customerRental;
    }

    public void setCustomerRental(Customer customerRental) {
        this.customerRental = customerRental;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Staff getStaffRental() {
        return staffRental;
    }

    public void setStaffRental(Staff staffRental) {
        this.staffRental = staffRental;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", rentalDate=" + rentalDate +
                ", customerRental=" + customerRental +
                ", returnDate=" + returnDate +
                ", staffRental=" + staffRental +
                ", lastUpdate=" + lastUpdate +
                ", payments=" + payments +
                '}';
    }
}
