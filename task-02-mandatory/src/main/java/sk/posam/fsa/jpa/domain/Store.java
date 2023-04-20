package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "store", schema = "public")
@Access(AccessType.FIELD)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "store")
    private Set<Customer> customer;

    @OneToMany(mappedBy = "inventoryStore")
    private Set<Inventory> inventories;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", staff=" + staff +
                ", address=" + address +
                ", lastUpdate=" + lastUpdate +
                ", customer=" + customer +
                ", inventories=" + inventories +
                '}';
    }
}
