package com.capgemini.types;

public class OfficeTOBuilder {

    private Integer id;
    private String adress;
    private String telephone;
    private String email;


    public OfficeTOBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public OfficeTOBuilder withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public OfficeTOBuilder withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public OfficeTOBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public OfficeTO build() {

        return new OfficeTO(this.id, this.adress, this.telephone, this.email);
    }


}
