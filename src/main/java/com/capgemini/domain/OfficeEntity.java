package com.capgemini.domain;


import com.sun.istack.internal.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "office")
public class OfficeEntity extends BaseEntity{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "office_id", length = 11)
    private Integer id;

    @Column(name = "adress", length = 200)
    private String adress;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @Column(name = "email", length = 50)
    private String email;

    @OneToOne(mappedBy = "office", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private EmployeeEntity employee;

    @OneToOne(mappedBy = "officeFrom", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private LoanEntity loanFrom;

    @OneToOne(mappedBy = "officeTo", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private LoanEntity loanTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LoanEntity getLoanFrom() {
        return loanFrom;
    }

    public void setLoanFrom(LoanEntity loanFrom) {
        this.loanFrom = loanFrom;
    }

    public LoanEntity getLoanTo() {
        return loanTo;
    }

    public void setLoanTo(LoanEntity loanTo) {
        this.loanTo = loanTo;
    }
}
