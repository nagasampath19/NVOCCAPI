package com.nvoccapi.nvoccapibackend.dto;

public class ShipperDetailsSearchDTO {
    private String shippername;
    private String email;
    private String phone;

    public String getShippername() {
        return shippername;
    }

    public void setShippername(String shippername) {
        this.shippername = shippername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
