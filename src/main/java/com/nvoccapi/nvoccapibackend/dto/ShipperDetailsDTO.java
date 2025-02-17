package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ShipperDetailsDTO {

    @NotEmpty(message = "Shipper name is required")
    @Size(max = 100, message = "Shipper name must be at most 100 characters")
    private String shipperName;

    @NotEmpty(message = "Address1 is required")
    @Size(max = 200, message = "Address1 must be at most 200 characters")
    private String shipperAddress1;

    @Size(max = 200, message = "Address2 must be at most 200 characters")
    private String shipperAddress2;

    @NotEmpty(message = "City is required")
    @Size(max = 100, message = "City must be at most 100 characters")
    private String shipperCity;

    @NotEmpty(message = "State is required")
    @Size(max = 100, message = "State must be at most 100 characters")
    private String shipperState;

    @NotEmpty(message = "Country is required")
    @Size(max = 100, message = "Country must be at most 100 characters")
    private String shipperCountry;

    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be at most 100 characters")
    private String shipperEmail;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    @Size(max = 25, message = "Phone number must be at most 25 characters")
    private String shipperPhone;

    @Size(min = 5, max = 10, message = "Pin code should be between 5 and 10 characters")
    private String shipperPinCode;

    @Size(max = 50, message = "CIN must be at most 50 characters")
    private String shipperCIN;

    private int user_id;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    // Getters and Setters
    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperAddress1() {
        return shipperAddress1;
    }

    public void setShipperAddress1(String shipperAddress1) {
        this.shipperAddress1 = shipperAddress1;
    }

    public String getShipperAddress2() {
        return shipperAddress2;
    }

    public void setShipperAddress2(String shipperAddress2) {
        this.shipperAddress2 = shipperAddress2;
    }

    public String getShipperCity() {
        return shipperCity;
    }

    public void setShipperCity(String shipperCity) {
        this.shipperCity = shipperCity;
    }

    public String getShipperState() {
        return shipperState;
    }

    public void setShipperState(String shipperState) {
        this.shipperState = shipperState;
    }

    public String getShipperCountry() {
        return shipperCountry;
    }

    public void setShipperCountry(String shipperCountry) {
        this.shipperCountry = shipperCountry;
    }

    public String getShipperEmail() {
        return shipperEmail;
    }

    public void setShipperEmail(String shipperEmail) {
        this.shipperEmail = shipperEmail;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getShipperPinCode() {
        return shipperPinCode;
    }

    public void setShipperPinCode(String shipperPinCode) {
        this.shipperPinCode = shipperPinCode;
    }

    public String getShipperCIN() {
        return shipperCIN;
    }

    public void setShipperCIN(String shipperCIN) {
        this.shipperCIN = shipperCIN;
    }
    
}
