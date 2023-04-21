package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "public")
@Access(AccessType.FIELD)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressCustomer;

    @Column(name = "activebool")
    private boolean status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    @OneToOne(mappedBy = "customerRental")
    private Rental rental;

    @Column(name = "active")
    private int active;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(Address addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", store=" + store +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", addressCustomer=" + addressCustomer +
                ", status=" + status +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                ", payments=" + payments +
                ", rental=" + rental +
                ", active=" + active +
                '}';
    }
}
