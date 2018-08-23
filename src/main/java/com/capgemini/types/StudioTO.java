package com.capgemini.types;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;

public class StudioTO {

    private Integer id;
    private String city;
    private String country;
    private String studioName;
    private FilmEntity filmEntity;
    private ActorEntity actorEntity;

    public StudioTO() {

    }

    public StudioTO(Integer id, String city, String country, String studioName, FilmEntity filmEntity, ActorEntity actorEntity) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.studioName = studioName;
        this.filmEntity = filmEntity;
        this.actorEntity = actorEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public FilmEntity getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }

    public ActorEntity getActorEntity() {
        return actorEntity;
    }

    public void setActorEntity(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
    }
}
