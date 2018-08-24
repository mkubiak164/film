package com.capgemini.domain;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="studio")
public class StudioEntity extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="studio_id", length = 11)
    private Integer id;

    @Column(name="city", length = 30)
    private String city;

    @Column(name="country", length = 30)
    private String country;

    @Column(name="studio_name", length = 30)
    private String studioName;


    @OneToMany (mappedBy = "studio", cascade = CascadeType.REMOVE)
    private Collection<FilmEntity> films;

    @ManyToOne
    private ActorEntity actorEntity;

    @Version
    @Column(name="version")
    private Long version;


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

    public Collection<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ActorEntity getActorEntity() {
        return actorEntity;
    }

    public void setActorEntity(ActorEntity actorEntity) {
        this.actorEntity = actorEntity;
    }


}
