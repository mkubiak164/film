package com.capgemini.domain;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="film")
public class FilmEntity extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", length = 11)
    private Integer id;

    @Column(name="title", length = 50)
    private String title;

    @Column(name="kind", length = 30)
    private String kind;

    @Column(name="type")
    private Enum type;

    @Column(name="film_Length", length = 10)
    private Integer length;

    @Column(name="premier_Date")  //TODO
    private LocalDate premierDate;

    @Column(name="country", length = 30)
    private String country;

    @Column(name="is3d")
    private Boolean is3d;

    @Column(name="budget", length = 30)
    private Long budget;

    @Column(name="profit_total", length = 30)
    private Long profitTotal;

    @Column(name="profit_1st_week", length = 30)
    private Long profit1stWeek;


    @ManyToMany(mappedBy = "filmEntities", cascade = CascadeType.REMOVE)
    private Collection<ActorEntity> actorEntities;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private StudioEntity studio;

    @Version
    @Column(name="version")
    private Long version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getIs3d() {
        return is3d;
    }

    public void setIs3d(Boolean is3d) {
        this.is3d = is3d;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getProfitTotal() {
        return profitTotal;
    }

    public void setProfitTotal(Long profitTotal) {
        this.profitTotal = profitTotal;
    }

    public Long getProfit1stWeek() {
        return profit1stWeek;
    }

    public void setProfit1stWeek(Long profit1stWeek) {
        this.profit1stWeek = profit1stWeek;
    }

    public Collection<ActorEntity> getActorEntities() {
        return actorEntities;
    }

    public void setActorEntities(Collection<ActorEntity> actorEntities) {
        this.actorEntities = actorEntities;
    }

    public StudioEntity getStudio() {
        return studio;
    }

    public void setStudio(StudioEntity studio) {
        this.studio = studio;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
