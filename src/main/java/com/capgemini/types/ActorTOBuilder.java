package com.capgemini.types;

import com.capgemini.domain.FilmEntity;
import com.capgemini.domain.StudioEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Date;

public class ActorTOBuilder {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Collection<StudioEntity> studioEntities;
    private Collection<FilmEntity> filmEntities;


    public ActorTOBuilder withID(Integer id) {
        this.id = id;
        return this;
    }

    public ActorTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ActorTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ActorTOBuilder withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public ActorTO build() {
        return new ActorTO(this.id, this.firstName, this.lastName, this.dateOfBirth);
    }

}
