package com.capgemini.domain;



import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan")
public class LoanEntity extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", length = 11)
    private Integer id;

    @Column(name = "employee_name", length = 20)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private CarEntity car;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="office_from_id", referencedColumnName="office_id")
    private OfficeEntity officeFrom;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="office_to_id", referencedColumnName="office_id")
    private OfficeEntity officeTo;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "price", length = 11)
    private Integer price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public OfficeEntity getOfficeFrom() {
        return officeFrom;
    }

    public void setOfficeFrom(OfficeEntity officeFrom) {
        this.officeFrom = officeFrom;
    }

    public OfficeEntity getOfficeTo() {
        return officeTo;
    }

    public void setOfficeTo(OfficeEntity officeTo) {
        this.officeTo = officeTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
