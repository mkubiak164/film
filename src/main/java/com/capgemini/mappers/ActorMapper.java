package com.capgemini.mappers;

import com.capgemini.domain.ActorEntity;
import com.capgemini.types.ActorTO;

import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {

    public static ActorEntity toActorEntity(ActorTO actorTO) {

        if(actorTO == null)
            return null;
        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setId(actorTO.getId());
        actorEntity.setFirstName(actorTO.getFirstName());
        actorEntity.setLastName(actorTO.getLastName());
        actorEntity.setDateOfBirth(actorTO.getDateOfBirth());
        actorEntity.setFilmEntities(actorTO.getFilmEntities());
        actorEntity.setStudioEntities(actorTO.getStudioEntities());

        return actorEntity;
    }

    public static ActorTO toActorTO(ActorEntity actorEntity) {

        if(actorEntity == null)
            return null;
        ActorTO actorTO = new ActorTO();
        actorTO.setId(actorEntity.getId());
        actorTO.setFirstName(actorEntity.getFirstName());
        actorTO.setLastName(actorEntity.getLastName());
        actorTO.setDateOfBirth(actorEntity.getDateOfBirth());
        actorTO.setFilmEntities(actorEntity.getFilmEntities());
        actorTO.setStudioEntities(actorEntity.getStudioEntities());

        return actorTO;
    }

    public static List<ActorTO> map2TOs(List<ActorEntity> actorEntities) {
        return actorEntities.stream().map(ActorMapper::toActorTO).collect(Collectors.toList());
    }

}



