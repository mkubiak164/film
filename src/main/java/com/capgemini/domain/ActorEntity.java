package com.capgemini.domain;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="actor")
public class ActorEntity extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id", length = 11)
    private Integer id;

    @Column(name="first_name", length = 30)
    private String firstName;

    @Column(name="last_name", length = 50)
    private String lastName;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    private StudioEntity studio;

    @ManyToMany (cascade = CascadeType.REMOVE)
    @JoinTable(name="films",
                joinColumns = {@JoinColumn(name = "actor_id")},
                inverseJoinColumns = { @JoinColumn(name = "film_id")}
                )
    private Collection<FilmEntity> filmEntities;


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
