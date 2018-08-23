package com.capgemini.domain;



import com.sun.istack.internal.NotNull;

import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp_position")
public class EmpPositionEntity extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id", length = 11)
    private Integer id;

    @Column(name = "position_type", length = 30)
    private String positionType;

    @OneToOne(mappedBy = "empPosition", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private EmployeeEntity employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
