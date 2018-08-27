package com.capgemini.types;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.StudioEntity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

public class FilmTOBuilder {

    private Integer id;
    private String title;
    private String kind;
    private Enum type;
    private Integer length;
    private LocalDate premierDate;
    private String country;
    private Boolean is3d;
    private Double budget;
    private Long profitTotal;
    private Long profit1stWeek;
    private Collection<ActorEntity> actorEntities;
    private StudioEntity studioEntity;

    public FilmTOBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public FilmTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public FilmTOBuilder withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public FilmTOBuilder withType(Enum type) {
        this.type = type;
        return this;
    }

    public FilmTOBuilder withLength(Integer length) {
        this.length = length;
        return this;
    }

    public FilmTOBuilder withPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
        return this;
    }

    public FilmTOBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public FilmTOBuilder with3d(Boolean is3d) {
        this.is3d = is3d;
        return this;
    }

    public FilmTOBuilder withBudget(Double budget) {
        this.budget = budget;
        return this;
    }

    public FilmTOBuilder withProfitTotal(Long profitTotal) {
        this.profitTotal = profitTotal;
        return this;
    }

    public FilmTOBuilder withProfit1stWeek(Long profit1stWeek) {
        this.profit1stWeek = profit1stWeek;
        return this;
    }

    public FilmTOBuilder withActorEntities(Collection<ActorEntity> actorEntities) {
        this.actorEntities = actorEntities;
        return this;
    }

    public FilmTOBuilder withStudioEntity(StudioEntity studioEntitiy) {
        this.studioEntity = studioEntity;
        return this;
    }

    public FilmTO build() {
        return new FilmTO(this.id, this.title, this.kind, this.type, this.length, this.premierDate, this.country, this.is3d, this.budget, this.profitTotal, this.profit1stWeek, this.actorEntities, this.studioEntity);
    }

}
