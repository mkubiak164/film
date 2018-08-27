package com.capgemini.service.impl;

import com.capgemini.dao.ActorDAO;
import com.capgemini.dao.FilmDAO;
import com.capgemini.dao.impl.ActorDAOImpl;
import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.mappers.ActorMapper;
import com.capgemini.service.ActorService;
import com.capgemini.types.ActorTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDAO actorRepository;

    private TransactionTemplate transactionTemplate;


    public ActorServiceImpl(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Override
    @Transactional
    public ActorTO addActor(ActorTO actorTO) {

        if(actorTO == null) {
            return null;
        }

        ActorEntity actorEntity = actorRepository.save(ActorMapper.toActorEntity(actorTO));
        return ActorMapper.toActorTO(actorEntity);
    }

    @Override
    @Transactional
    public ActorTO showActor(Integer id) {
        if( actorRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return ActorMapper.toActorTO(actorRepository.findOne(id));
    }

    @Override
    @Transactional
    public ActorTO editActor(ActorTO actorTO) {
        if(actorTO == null) {
            return null;
        }
        /*Collection<FilmEntity> newFilms = new ArrayList<FilmEntity>();
        newFilms = actorTO.getFilmEntities();
        FilmDAO filmDAO;*/


        ActorEntity actorEntity = ActorMapper.toActorEntity(actorTO);
        actorRepository.update(actorEntity);
        return ActorMapper.toActorTO(actorEntity);
    }

    @Override
    @Transactional
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
