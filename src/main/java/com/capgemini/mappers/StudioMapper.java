package com.capgemini.mappers;

import com.capgemini.domain.StudioEntity;
import com.capgemini.types.StudioTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudioMapper {


    public static StudioEntity toStudioEntity(StudioTO studioTO) {

        if(studioTO == null)
            return null;
        StudioEntity studioEntity = new StudioEntity();
        studioEntity.setId(studioTO.getId());
        studioEntity.setCity(studioTO.getCity());
        studioEntity.setCountry(studioTO.getCountry());
        studioEntity.setStudioName(studioTO.getStudioName());
        studioEntity.setFilmEntity(studioTO.getFilmEntity());
        studioEntity.setActorEntity(studioTO.getActorEntity());

        return studioEntity;
    }

    public static StudioTO toStudioTO(StudioEntity studioEntity) {

        if(studioEntity == null)
            return null;
        StudioTO studioTO = new StudioTO();
        studioTO.setId(studioEntity.getId());
        studioTO.setCity(studioEntity.getCity());
        studioTO.setCountry(studioEntity.getCountry());
        studioTO.setStudioName(studioEntity.getStudioName());
        studioTO.setFilmEntity(studioEntity.getFilmEntity());
        studioTO.setActorEntity(studioEntity.getActorEntity());

        return studioTO;
    }

    public static List<StudioTO> map2TOs(List<StudioEntity> studioEntities) {
        return studioEntities.stream().map(StudioMapper::toStudioTO).collect(Collectors.toList());
    }

}
