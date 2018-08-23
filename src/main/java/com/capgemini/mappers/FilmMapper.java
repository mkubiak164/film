package com.capgemini.mappers;

import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.types.FilmTO;

import java.util.List;
import java.util.stream.Collectors;

public class FilmMapper {

    public static FilmEntity toFilmEntity(FilmTO filmTO) {

        if(filmTO == null)
            return null;

        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(filmTO.getId());
        filmEntity.setTitle(filmTO.getTitle());
        filmEntity.setKind(filmTO.getKind());
        filmEntity.setType(filmTO.getType());
        filmEntity.setLength(filmTO.getLength());
        filmEntity.setPremierDate(filmTO.getPremierDate());
        filmEntity.setCountry(filmTO.getCountry());
        filmEntity.setIs3d(filmTO.getIs3d());
        filmEntity.setBudget(filmTO.getBudget());
        filmEntity.setProfitTotal(filmTO.getProfitTotal());
        filmEntity.setProfit1stWeek(filmTO.getProfit1stWeek());
        filmEntity.setActorEntities(filmTO.getActorEntities());
        filmEntity.setStudioEntities(filmTO.getStudioEntities());

        return filmEntity;
    }


    public static FilmTO toFilmTO(FilmEntity filmEntity) {

        if(filmEntity == null)
            return null;

        FilmTO filmTO = new FilmTO();
        filmTO.setId(filmEntity.getId());
        filmTO.setTitle(filmEntity.getTitle());
        filmTO.setKind(filmEntity.getKind());
        filmTO.setType(filmEntity.getType());
        filmTO.setLength(filmEntity.getLength());
        filmTO.setPremierDate(filmEntity.getPremierDate());
        filmTO.setCountry(filmEntity.getCountry());
        filmTO.setIs3d(filmEntity.getIs3d());
        filmTO.setBudget(filmEntity.getBudget());
        filmTO.setProfitTotal(filmEntity.getProfitTotal());
        filmTO.setProfit1stWeek(filmEntity.getProfit1stWeek());
        filmTO.setActorEntities(filmEntity.getActorEntities());
        filmTO.setStudioEntities(filmTO.getStudioEntities());

        return filmTO;
    }

    public static List<FilmTO> map2TOs(List<FilmEntity> filmEntities) {
        return filmEntities.stream().map(FilmMapper::toFilmTO).collect(Collectors.toList());
    }

}


