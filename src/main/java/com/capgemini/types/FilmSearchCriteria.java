package com.capgemini.types;

import java.util.Date;

public class FilmSearchCriteria {

    private String kind;
    private Enum type;
    private Integer length;
    private Date premierDate;
    private Boolean is3d;
    private Integer studioId;

    public FilmSearchCriteria(String kind, Enum type, Integer length, Date premierDate, Boolean is3d, Integer studioId) {
        this.kind = kind;
        this.type = type;
        this.length = length;
        this.premierDate = premierDate;
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
