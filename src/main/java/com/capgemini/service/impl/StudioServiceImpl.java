package com.capgemini.service.impl;

import com.capgemini.dao.impl.StudioDAOImpl;
import com.capgemini.domain.StudioEntity;
import com.capgemini.mappers.StudioMapper;
import com.capgemini.service.StudioService;
import com.capgemini.types.StudioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    private StudioDAOImpl studioRepository;

    @Override
    public StudioTO addStudio(StudioTO studioTO) {
        StudioEntity studioEntity = StudioMapper.toStudioEntity(studioTO);
        studioRepository.save(studioEntity);
        return  StudioMapper.toStudioTO(studioEntity);
    }

    @Override
    public StudioTO showStudio(Integer id) {
       return StudioMapper.toStudioTO(studioRepository.findOne(id));
    }

    @Override
    public StudioTO editStudio(StudioTO studio) {
        StudioEntity studioEntity = StudioMapper.toStudioEntity(studio);
        studioRepository.update(studioEntity);
        return StudioMapper.toStudioTO(studioEntity);
    }

    @Override
    public void removeStudio(Integer id) {
        studioRepository.delete(id);
    }
}
