package com.capgemini.types;

import java.time.LocalDate;

public class CarToBuilder {

    private String carType;
    private String mark;
    private LocalDate year;
    private String color;
    private Integer engineCapacity;
    private double power;
    private Integer mileage;
    private Integer id;

    public CarToBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public CarToBuilder withCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public CarToBuilder withMark(String mark) {
        this.mark = mark;
        return this;
    }

    public CarToBuilder withYearOfProduction(LocalDate year) {
        this.year = year;
        return this;
    }

    public CarToBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CarToBuilder withEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
        return this;
    }

    public CarToBuilder withPower(double power) {
        this.power = power;
        return this;
    }

    public CarToBuilder withMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }


    /**
     *
     * @return zwraca obiekt zbudowany na podstawie wybranych parametrów
     */
    public CarTO build() {
        return new CarTO(this.id, this.carType, this.mark, this.year, this.color, this.engineCapacity, this.power, this.mileage);
    }
}
