package no.inmeta.filmmanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;

import java.sql.Timestamp;

import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id") @NotNull
    private Integer filmId;

    @Column(name ="title") @NotNull
    private String title;

    @Column(name = "description") @Nullable
    private String description;

    @Column(name = "release_year") @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY")
    private Date releaseYear;

    @Column(name = "language_id") @NotNull
    private String languageId;

    @Column(name = "original_language_id") @Nullable
    private String originalLanguageId;


    @Column(name = "rental_duration") @NotNull
    private int rentalDuration;


    @Column(name = "rental_rate") @NotNull
    private float rentalRate;


    @Column(name = "length") @Nullable
    private int length;


    @Column(name = "replacement_cost") @NotNull
    private float replacementCost;


    @Column(name = "rating") @Nullable
    private String rating;


    @Column(name = "special_features") @Nullable
    private String specialFeatures;


    @Column(name = "last_update") @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp lastUpdate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName= "actor_id"))
    private Set<Actor> actors;

    public Film (){

    }

    public Film(Film film){
        this.title = film.title;
        this.description = film.description;
        this.releaseYear = film.releaseYear;
        this.languageId = film.languageId;
        this.originalLanguageId = film.originalLanguageId;
        this.rentalDuration = film.rentalDuration;
        this.rentalRate = film.rentalRate;
        this.length = film.length;
        this.replacementCost = film.replacementCost;
        this.rating = film.rating;
        this.specialFeatures = film.specialFeatures;
    }

    public Film(Integer filmId, String title, String description, Date release_year, String language_id,
                String original_language_id,int rental_duration,float rental_rate,  int length,
                float replacement_cost,String rating, String special_features, Timestamp lastUpdate){

         this.title = title;
         this.description = description;
         this.releaseYear = release_year;
         this.languageId = language_id;
         this.originalLanguageId = original_language_id;
         this.rentalDuration = rental_duration;
         this.rentalRate = rental_rate;
         this.length = length;
         this.replacementCost = replacement_cost;
         this.rating = rating;
         this.specialFeatures = special_features;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
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

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(String originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
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

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
