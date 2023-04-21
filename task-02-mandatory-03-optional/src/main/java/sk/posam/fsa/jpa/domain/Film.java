package sk.posam.fsa.jpa.domain;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "film", schema = "public")
@Access(AccessType.FIELD)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> filmCategories;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "rental_duration")
    private int rentalDuration;

    @Column(name = "rental_rate")
    private float rentalRate;

    @Column(name = "length")
    private int length;

    @Column(name = "replacement_cost")
    private float replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "fulltext")
    private String fulltext;

    @OneToMany(mappedBy = "inventoryFilm")
    private Set<Inventory> inventories;

    public Set<Category> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(Set<Category> filmCategories) {
        this.filmCategories = filmCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(float replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", filmCategories=" + filmCategories +
                ", actors=" + actors +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", language=" + language +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating='" + rating + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", fulltext='" + fulltext + '\'' +
                ", inventories=" + inventories +
                '}';
    }
}
