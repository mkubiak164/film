package com.capgemini.service;

import com.capgemini.domain.StudioEntity;
import com.capgemini.types.StudioTO;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.List;

public interface StudioService {

    StudioTO addStudio(StudioTO studio);

    StudioTO showStudio(Integer id);

    StudioTO editStudio(StudioTO studio);

    void removeStudio(Integer id);

    List<StudioTO> findAll();

}
