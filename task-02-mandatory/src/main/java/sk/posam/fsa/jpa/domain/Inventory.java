package sk.posam.fsa.jpa.domain;

import jdk.jfr.MemoryAddress;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventory", schema = "public")
@Access(AccessType.FIELD)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film inventoryFilm;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store inventoryStore;

    @Column(name = "last_update")
    private Date lastUpdate;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getInventoryFilm() {
        return inventoryFilm;
    }

    public void setInventoryFilm(Film inventoryFilm) {
        this.inventoryFilm = inventoryFilm;
    }

    public Store getInventoryStore() {
        return inventoryStore;
    }

    public void setInventoryStore(Store inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", inventoryFilm=" + inventoryFilm +
                ", inventoryStore=" + inventoryStore +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
