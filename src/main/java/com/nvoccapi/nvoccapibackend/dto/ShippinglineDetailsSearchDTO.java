package com.nvoccapi.nvoccapibackend.dto;

public class ShippinglineDetailsSearchDTO {
    private String shippinglinecode;
    private String shippinglinename;
    private String shippinglinetype;

    // Getters and Setters
    public String getShippinglinecode() {
        return shippinglinecode;
    }

    public void setShippinglinecode(String shippinglinecode) {
        this.shippinglinecode = shippinglinecode;
    }

    public String getShippinglinename() {
        return shippinglinename;
    }

    public void setShippinglinename(String shippinglinename) {
        this.shippinglinename = shippinglinename;
    }

    public String getShippinglinetype() {
        return shippinglinetype;
    }

    public void setShippinglinetype(String shippinglinetype) {
        this.shippinglinetype = shippinglinetype;
    }
}
