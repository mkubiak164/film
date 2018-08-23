package com.capgemini.service;

import com.capgemini.domain.ActorEntity;
import com.capgemini.types.ActorTO;

import java.util.List;

public interface ActorService {

    ActorTO addActor(ActorTO actor);

    ActorTO showActor(Integer id);

    ActorTO editActor(ActorTO actor);

    void removeActor(Integer id);

    List<ActorTO> findAllActors();

}
