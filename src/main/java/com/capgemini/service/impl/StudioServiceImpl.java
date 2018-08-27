package com.capgemini.service.impl;

import com.capgemini.dao.StudioDAO;
import com.capgemini.dao.impl.StudioDAOImpl;
import com.capgemini.domain.StudioEntity;
import com.capgemini.mappers.StudioMapper;
import com.capgemini.service.StudioService;
import com.capgemini.types.StudioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioDAO studioRepository;

    private TransactionTemplate transactionTemplate;


    public StudioServiceImpl(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    /**
     * dodawanie studia
     * @param studioTO
     * @return
     */
    @Override
    public StudioTO addStudio(StudioTO studioTO) {

        if(studioTO == null) {
            return null;
        }

        StudioEntity studioEntity = StudioMapper.toStudioEntity(studioTO);
        studioRepository.save(studioEntity);
        return  StudioMapper.toStudioTO(studioEntity);
    }

    /**
     * podgląd studia
     * @param id
     * @return
     */
    @Override
    public StudioTO showStudio(Integer id) {

        if(studioRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return StudioMapper.toStudioTO(studioRepository.findOne(id));
    }

    /**
     * edycja studia
     * @param studio
     * @return
     */
    @Override
    public StudioTO editStudio(StudioTO studio) {

        if(studio == null) {
            return null;
        }

        StudioEntity studioEntity = StudioMapper.toStudioEntity(studio);
        studioRepository.update(studioEntity);
        return StudioMapper.toStudioTO(studioEntity);
    }

    /*
    usuwanie studia
     */
    @Override
    public void removeStudio(Integer id) {

        if(studioRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        studioRepository.delete(id);
    }

    /**
     * metoda potrzebna do testów
     * @return
     */
    @Override
    public List<StudioTO> findAll() {
        return StudioMapper.map2TOs(studioRepository.findAll());
    }
}
