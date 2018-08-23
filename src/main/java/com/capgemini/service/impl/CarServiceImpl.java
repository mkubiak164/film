package com.capgemini.service.impl;

import com.capgemini.dao.CarDAO;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.CarService;
import com.capgemini.types.CarTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carRepository;

    @Override
    public CarTO addCar(CarTO carTO) {
        CarEntity carEntity = carRepository.save(CarMapper.toCarEntity(carTO));
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    public void removeCar(Integer id) {
        carRepository.delete(id);
    }

    @Override
    public CarTO editCar(CarTO carTO) {
        CarEntity carEntity = CarMapper.toCarEntity(carTO);
        carRepository.update(carEntity);
        return CarMapper.toCarTO(carEntity);
    }

    @Override
    public List<CarTO> findByTypeAndMark(String type, String mark) {
       List<CarEntity> carsByTypeAndMark = carRepository.findByTypeAndMark(type, mark);
        return CarMapper.map2TOs(carsByTypeAndMark);
    }

    @Override
    public List<CarTO> findByKeeper(Integer keeperId) {
        List<CarEntity> carsByKeeper = carRepository.findByKeeper(keeperId);
        return CarMapper.map2TOs(carsByKeeper);
    }

    @Override
    public List<CarTO> findAllCars() {
        return CarMapper.map2TOs(carRepository.findAll());
    }

    @Override
    public CarTO findById(Integer id) {
        return CarMapper.toCarTO(carRepository.findOne(id));
    }

    @Override
    public void assignCarToKeeper(Integer keepCarId, Integer employeeId) {

    }


}
