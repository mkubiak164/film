package com.capgemini.types;

import java.time.LocalDate;
import java.util.Date;

public class CarTO {



    private Integer id;
    private String carType;
    private String mark;
    private LocalDate yearOfProduction;
    private String color;
    private Integer engineCapacity;
    private Double power;
    private Integer mileage;

    public CarTO() {

    }

    public CarTO(Integer id, String carType, String mark, LocalDate yearOfProduction,
                 String color, Integer engineCapacity, Double power,
                 Integer mileage) {

        this.id = id;
        this.carType = carType;
        this.mark = mark;
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.power = power;
        this.mileage = mileage;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
