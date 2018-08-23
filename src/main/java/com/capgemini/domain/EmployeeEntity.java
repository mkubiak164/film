package com.capgemini.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", length = 11)
    private Integer id;

    @Column(name = "employee_name", length = 20)
    private String name;

    @Column(name = "employee_lastname", length = 45)
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private EmpPositionEntity empPosition;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private OfficeEntity office;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private KeeperEntity keeper;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EmpPositionEntity getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(EmpPositionEntity empPosition) {
        this.empPosition = empPosition;
    }

    public OfficeEntity getOffice() {
        return office;
    }

    public void setOffice(OfficeEntity office) {
        this.office = office;
    }

    public KeeperEntity getKeeper() {
        return keeper;
    }

    public void setKeeper(KeeperEntity keeper) {
        this.keeper = keeper;
    }
}
