package com.capgemini.types;

import com.capgemini.domain.FilmEntity;
import com.capgemini.domain.StudioEntity;

import java.util.Collection;
import java.util.Date;

public class ActorTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private StudioEntity studio;
    private Collection<FilmEntity> filmEntities;

    public ActorTO() {

    }

    public ActorTO(Integer id, String firstName, String lastName, Date dateOfBirth, Collection<FilmEntity> filmEntities, StudioEntity studio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.filmEntities = filmEntities;
        this.studio = studio;
    }

    public ActorTO(Integer id, String firstName, String lastName, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StudioEntity getStudio() {
        return studio;
    }

    public void setStudio(StudioEntity studio) {
        this.studio = studio;
    }

    public Collection<FilmEntity> getFilmEntities() {
        return filmEntities;
    }

    public void setFilmEntities(Collection<FilmEntity> filmEntities) {
        this.filmEntities = filmEntities;
    }
}
