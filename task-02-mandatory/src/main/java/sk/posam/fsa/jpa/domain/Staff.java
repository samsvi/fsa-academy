package sk.posam.fsa.jpa.domain;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "staff")
@Access(AccessType.FIELD)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address addressStaff;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "staff")
    private Store store;

    @Column(name = "active")
    private String status;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private Date lastUpdate;

    /*
    //pre bytearea som nasiel toto
    @Lob
    @Column(name = "picture")
    private byte[] picture;
*/
    @OneToMany(mappedBy = "staffPayment")
    private Set<Payment> payments;

    @OneToMany(mappedBy = "staffRental")
    private Set<Rental> rentals;

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
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

    public Address getAddressStaff() {
        return addressStaff;
    }

    public void setAddressStaff(Address addressStaff) {
        this.addressStaff = addressStaff;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressStaff=" + addressStaff +
                ", email='" + email + '\'' +
                ", store=" + store +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", payments=" + payments +
                ", rentals=" + rentals +
                '}';
    }
}
