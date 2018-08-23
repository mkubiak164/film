package com.capgemini.service;

import com.capgemini.types.CarTO;

import java.util.List;

public interface CarService {

    CarTO addCar(CarTO car);

    void removeCar (Integer id);

    CarTO editCar (CarTO car);

    void assignCarToKeeper(Integer keepCarId, Integer employeeId);

    List<CarTO> findByTypeAndMark (String type, String mark);

    List<CarTO> findByKeeper (Integer keeperId);

    List<CarTO> findAllCars ();

    CarTO findById(Integer id);


}
