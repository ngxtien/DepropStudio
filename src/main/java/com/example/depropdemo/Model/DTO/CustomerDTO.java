package com.example.depropdemo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {
    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")

    private String lastname;

    @JsonProperty("phonenumber")

    private String phonenumber;

    @JsonProperty("address")

    private String address;

    @JsonProperty("email")

    private String email;

    @JsonProperty("company")

    private String company;

    @JsonProperty("note")

    private String note; // Ghi chú đơn hàng

    @JsonProperty("vat")

    private Boolean vat;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getVat() {
        return vat;
    }

    public void setVat(Boolean vat) {
        this.vat = vat;
    }
}
