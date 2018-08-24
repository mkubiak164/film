package com.capgemini.types;

import java.time.LocalDate;
import java.util.Date;

public class FilmSearchCriteria {

    private String kind;
    private Enum type;
    private Integer lengthFrom;
    private Integer lengthTo;
    private LocalDate premierDateFrom;
    private LocalDate premierDateTo;
    private Boolean is3d;
    private Integer studioId;


    public FilmSearchCriteria(String kind, Enum type, Integer lengthFrom, Integer lengthTo, LocalDate premierDateFrom, LocalDate premierDateTo, Boolean is3d, Integer studioId) {
        this.kind = kind;
        this.type = type;
        this.lengthFrom = lengthFrom;
        this.lengthTo = lengthTo;
        this.premierDateFrom = premierDateFrom;
        this.premierDateTo = premierDateTo;
        this.is3d = is3d;
        this.studioId = studioId;
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

    public Integer getLengthFrom() {
        return lengthFrom;
    }

    public void setLengthFrom(Integer lengthFrom) {
        this.lengthFrom = lengthFrom;
    }

    public Integer getLengthTo() {
        return lengthTo;
    }

    public void setLengthTo(Integer lengthTo) {
        this.lengthTo = lengthTo;
    }

    public LocalDate getPremierDateFrom() {
        return premierDateFrom;
    }

    public void setPremierDateFrom(LocalDate premierDateFrom) {
        this.premierDateFrom = premierDateFrom;
    }

    public LocalDate getPremierDateTo() {
        return premierDateTo;
    }

    public void setPremierDateTo(LocalDate premierDateTo) {
        this.premierDateTo = premierDateTo;
    }

    public Boolean getIs3d() {
        return is3d;
    }

    public void setIs3d(Boolean is3d) {
        this.is3d = is3d;
    }

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }
}
