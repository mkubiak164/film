package com.capgemini.types;

public class OfficeTO {

    private Integer id;
    private String adress;
    private String telephone;
    private String email;

    public OfficeTO() {

    }


    public OfficeTO(Integer id, String adress, String telephone, String email) {
        this.id = id;
        this.adress = adress;
        this.telephone = telephone;
        this.email = email;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
