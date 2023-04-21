package sk.posam.fsa.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "city", schema = "public")
@Access(AccessType.FIELD)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "city")
    private Set<Address> addresses;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                ", lastUpdate=" + lastUpdate +
                ", addresses=" + addresses +
                '}';
    }
}
