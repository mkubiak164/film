package com.capgemini.mappers;

import com.capgemini.domain.CarEntity;
import com.capgemini.types.CarTO;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarEntity toCarEntity(CarTO carTO) {

        if(carTO == null)
            return null;
        CarEntity carEntity = new CarEntity();
        carEntity.setId(carTO.getId());
        carEntity.setCarType(carTO.getCarType());
        carEntity.setMark(carTO.getMark());
        carEntity.setYearOfProduction(carTO.getYearOfProduction());
        carEntity.setColor(carTO.getColor());
        carEntity.setEngineCapacity(carTO.getEngineCapacity());
        carEntity.setPower(carTO.getPower());
        carEntity.setMileage(carTO.getMileage());

        return carEntity;
    }

    public static CarTO toCarTO(CarEntity carEntity) {

        if(carEntity == null)
            return null;
        CarTO carTO = new CarTO();
        carTO.setId(carEntity.getId());
        carTO.setCarType(carEntity.getCarType());
        carTO.setMark(carEntity.getMark());
        carTO.setYearOfProduction(carEntity.getYearOfProduction());
        carTO.setColor(carEntity.getColor());
        carTO.setEngineCapacity(carEntity.getEngineCapacity());
        carTO.setPower(carEntity.getPower());
        carTO.setMileage(carEntity.getMileage());

        return carTO;
    }

    public static List<CarTO> map2TOs(List<CarEntity> carEntities){
        return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
    }


}
