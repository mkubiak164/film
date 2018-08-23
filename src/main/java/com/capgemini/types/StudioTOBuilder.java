package com.capgemini.types;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;

public class StudioTOBuilder {

    private Integer id;
    private String city;
    private String country;
    private String studioName;
    private FilmEntity filmEntity;
    private ActorEntity actorEntity;


    public StudioTOBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public StudioTOBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public StudioTOBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public StudioTOBuilder withStudioName(String studioName) {
        this.studioName = studioName;
        return this;
    }

    public StudioTOBuilder withFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
        return this;
    }

    public StudioTOBuilder withActorEntity(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
        return this;
    }

    public StudioTO build() {

        return new StudioTO(this.id, this.city, this.country, this.studioName, this.filmEntity, this.actorEntity);
    }

}
