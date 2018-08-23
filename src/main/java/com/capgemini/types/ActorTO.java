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
    private Collection<StudioEntity> studioEntities;
    private Collection<FilmEntity> filmEntities;

    public ActorTO() {

    }

    public ActorTO(Integer id, String firstName, String lastName, Date dateOfBirth, Collection<FilmEntity> filmEntities, Collection<StudioEntity> studioEntities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.filmEntities = filmEntities;
        this.studioEntities = studioEntities;
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

    public Collection<StudioEntity> getStudioEntities() {
        return studioEntities;
    }

    public void setStudioEntities(Collection<StudioEntity> studioEntities) {
        this.studioEntities = studioEntities;
    }

    public Collection<FilmEntity> getFilmEntities() {
        return filmEntities;
    }

    public void setFilmEntities(Collection<FilmEntity> filmEntities) {
        this.filmEntities = filmEntities;
    }
}
