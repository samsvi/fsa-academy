package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment", schema = "public")
@Access(AccessType.FIELD)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staffPayment;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rentalPayment;

    @Column(name = "amount")
    private float amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaffPayment() {
        return staffPayment;
    }

    public void setStaffPayment(Staff staffPayment) {
        this.staffPayment = staffPayment;
    }

    public Rental getRentalPayment() {
        return rentalPayment;
    }

    public void setRentalPayment(Rental rentalPayment) {
        this.rentalPayment = rentalPayment;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", customer=" + customer +
                ", staffPayment=" + staffPayment +
                ", rentalPayment=" + rentalPayment +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
