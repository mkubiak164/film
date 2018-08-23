package com.capgemini.service.impl;

import com.capgemini.dao.ActorDAO;
import com.capgemini.dao.impl.ActorDAOImpl;
import com.capgemini.domain.ActorEntity;
import com.capgemini.mappers.ActorMapper;
import com.capgemini.service.ActorService;
import com.capgemini.types.ActorTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDAOImpl actorRepository;

    @Override
    public ActorTO addActor(ActorTO actorTO) {
        if(actorTO == null) {
            return null;
        }
        ActorEntity actorEntity = actorRepository.save(ActorMapper.toActorEntity(actorTO));
        return ActorMapper.toActorTO(actorEntity);
    }

    @Override
    public ActorTO showActor(Integer id) {
        if( actorRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return ActorMapper.toActorTO(actorRepository.findOne(id));
    }

    @Override
    public ActorTO editActor(ActorTO actorTO) {
        if(actorTO == null) {
            return null;
        }
        ActorEntity actorEntity = ActorMapper.toActorEntity(actorTO);
        actorRepository.update(actorEntity);
        return ActorMapper.toActorTO(actorEntity);
    }

    @Override
    public void removeActor(Integer id) {
        if(actorRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        actorRepository.delete(id);
    }

    @Override
    public List<ActorTO> findAllActors() {
        return ActorMapper.map2TOs(actorRepository.findAll());
    }


}
