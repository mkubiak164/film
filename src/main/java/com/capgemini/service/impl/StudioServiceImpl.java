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

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioDAO studioRepository;

    @Override
    public StudioTO addStudio(StudioTO studioTO) {

        if(studioTO == null) {
            return null;
        }

        StudioEntity studioEntity = StudioMapper.toStudioEntity(studioTO);
        studioRepository.save(studioEntity);
        return  StudioMapper.toStudioTO(studioEntity);
    }

    @Override
    public StudioTO showStudio(Integer id) {

        if(studioRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        return StudioMapper.toStudioTO(studioRepository.findOne(id));
    }

    @Override
    public StudioTO editStudio(StudioTO studio) {

        if(studio == null) {
            return null;
        }

        StudioEntity studioEntity = StudioMapper.toStudioEntity(studio);
        studioRepository.update(studioEntity);
        return StudioMapper.toStudioTO(studioEntity);
    }

    @Override
    public void removeStudio(Integer id) {

        if(studioRepository.findOne(id) == null) {
            throw new NullPointerException();
        }
        studioRepository.delete(id);
    }

    @Override
    public List<StudioTO> findAll() {
        return StudioMapper.map2TOs(studioRepository.findAll());
    }
}
