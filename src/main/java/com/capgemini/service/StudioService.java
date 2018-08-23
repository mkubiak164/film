package com.capgemini.service;

import com.capgemini.types.StudioTO;

public interface StudioService {

    StudioTO addStudio(StudioTO studio);

    StudioTO showStudio(Integer id);

    StudioTO editStudio(StudioTO studio);

    void removeStudio(Integer id);


}
