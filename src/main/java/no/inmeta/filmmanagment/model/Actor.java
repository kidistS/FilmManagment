package no.inmeta.filmmanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
//import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id") @NotNull
    private Integer actorId;


    @Column(name = "first_name") @NotNull
    private String fistName;


    @Column(name = "last_name") @NotNull
    private String lastName;


    @Column(name = "last_update") @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD HH:MM:SS")
    private Timestamp lastUpdate;

    @ManyToMany (mappedBy = "actors")
    private Set<Film> films;

    public Actor(){
    }

    public Actor(Actor actor){
        this.fistName = actor.fistName;
        this.lastName = actor.lastName;
        this.lastUpdate = actor.lastUpdate;
    }


    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
