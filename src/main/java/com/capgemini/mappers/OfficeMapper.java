package com.capgemini.mappers;

import com.capgemini.domain.OfficeEntity;
import com.capgemini.types.OfficeTO;

import java.util.List;
import java.util.stream.Collectors;

public class OfficeMapper {

    public static OfficeEntity toOfficeEntity(OfficeTO officeTO) {

        if(officeTO == null)
            return null;

        OfficeEntity officeEntity = new OfficeEntity();
        officeEntity.setId(officeTO.getId());
        officeEntity.setAdress(officeTO.getAdress());
        officeEntity.setTelephone(officeTO.getTelephone());
        officeEntity.setEmail(officeTO.getEmail());

        return officeEntity;
    }


    public static OfficeTO toOfficeTO(OfficeEntity officeEntity) {

        if(officeEntity == null)
            return null;

        OfficeTO officeTO = new OfficeTO();
        officeTO.setId(officeEntity.getId());
        officeTO.setAdress(officeEntity.getAdress());
        officeTO.setTelephone(officeEntity.getTelephone());
        officeTO.setEmail(officeEntity.getTelephone());

        return officeTO;
    }


    public static List<OfficeTO> map2TOs(List<OfficeEntity> officeEntities) {
        return officeEntities.stream().map(OfficeMapper::toOfficeTO).collect(Collectors.toList());
    }
}
