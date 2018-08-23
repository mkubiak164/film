package com.capgemini.domain;


import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "car")
public class CarEntity extends BaseEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", length = 11)
    private Integer id;

    @Column(name = "car_type", length = 30)
    private String carType;

    @Column(name = "mark", length = 30)
    private String mark;

    @Column(name = "yearOfProduction", length =4 )
    private LocalDate yearOfProduction;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "engineCapacity", length = 11)
    private Integer engineCapacity;

    @Column(name = "power", length = 10)
    private Double power;

    @Column(name = "mileage", length = 10)
    private Integer mileage;

    @OneToOne(mappedBy = "car", cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private LoanEntity loan;

    @ManyToMany(mappedBy = "cars")
    private List<KeeperEntity> keepers;


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

    public LoanEntity getLoan() {
        return loan;
    }

    public void setLoan(LoanEntity loan) {
        this.loan = loan;
        this.loan.setCar(this);
    }

    public List<KeeperEntity> getKeepers() {
        return keepers;
    }

    public void setKeepers(List<KeeperEntity> keepers) {
        this.keepers = keepers;
    }
}
