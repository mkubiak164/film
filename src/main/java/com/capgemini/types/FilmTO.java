package com.capgemini.types;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.StudioEntity;

import java.util.Collection;
import java.util.Date;

public class FilmTO {

    private Integer id;
    private String title;
    private String kind;
    private Enum type;
    private Integer length;
    private Date premierDate;
    private String country;
    private Boolean is3d;
    private Long budget;
    private Long profitTotal;
    private Long profit1stWeek;
    private Collection<ActorEntity> actorEntities;
    private Collection<StudioEntity> studioEntities;

    public FilmTO() {

    }

    public FilmTO(Integer id, String title, String kind, Enum type, Integer length, Date premierDate, String country, Boolean is3d, Long budget, Long profitTotal, Long profit1stWeek, Collection<ActorEntity> actorEntities, Collection<StudioEntity> studioEntities) {
        this.id = id;
        this.title = title;
        this.kind = kind;
        this.type = type;
        this.length = length;
        this.premierDate = premierDate;
        this.country = country;
        this.is3d = is3d;
        this.budget = budget;
        this.profitTotal = profitTotal;
        this.profit1stWeek = profit1stWeek;
        this.actorEntities = actorEntities;
        this.studioEntities = studioEntities;
    }

    public FilmTO(Integer id, String title, String kind, Enum type, Integer length, Date premierDate, String country, Boolean is3d, Long budget, Long profitTotal, Long profit1stWeek) {
        this.id = id;
        this.title = title;
        this.kind = kind;
        this.type = type;
        this.length = length;
        this.premierDate = premierDate;
        this.country = country;
        this.is3d = is3d;
        this.budget = budget;
        this.profitTotal = profitTotal;
        this.profit1stWeek = profit1stWeek;

    }


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

    public Date getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(Date premierDate) {
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

    public Collection<StudioEntity> getStudioEntities() {
        return studioEntities;
    }

    public void setStudioEntities(Collection<StudioEntity> studioEntities) {
        this.studioEntities = studioEntities;
    }


}
