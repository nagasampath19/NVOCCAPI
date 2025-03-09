package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ConsigneeDetailsDTO {

    @NotEmpty(message = "Consignee name is required")
    @Size(max = 100, message = "Consignee name must be at most 100 characters")
    private String ConsigneeName;

    @NotEmpty(message = "Address1 is required")
    @Size(max = 200, message = "Address1 must be at most 200 characters")
    private String ConsigneeAddress1;

    @Size(max = 200, message = "Address2 must be at most 200 characters")
    private String ConsigneeAddress2;

    @NotEmpty(message = "City is required")
    @Size(max = 100, message = "City must be at most 100 characters")
    private String ConsigneeCity;

    @NotEmpty(message = "State is required")
    @Size(max = 100, message = "State must be at most 100 characters")
    private String ConsigneeState;

    @NotEmpty(message = "Country is required")
    @Size(max = 100, message = "Country must be at most 100 characters")
    private String ConsigneeCountry;

    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be at most 100 characters")
    private String ConsigneeEmail;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    @Size(max = 25, message = "Phone number must be at most 25 characters")
    private String ConsigneePhone;

    @Size(min = 5, max = 10, message = "Pin code should be between 5 and 10 characters")
    private String ConsigneePinCode;

    @Size(max = 50, message = "GSTIN Number must be at most 50 characters")
    private String ConsigneeGSTIN;

    @Size(max = 50, message = "PAN Number must be at most 50 characters")
    private String ConsigneePAN;

    @Size(max = 50, message = "IEC Code must be at most 50 characters")
    private String ConsigneeIEC;
   
    private int consignee_Id;
    private int user_id;
    // Getters and Setters
    public String getConsigneeName() {
        return ConsigneeName;
    }

    public void setConsigneeName(String ConsigneeName) {
        this.ConsigneeName = ConsigneeName;
    }

    public String getConsigneeAddress1() {
        return ConsigneeAddress1;
    }

    public void setConsigneeAddress1(String ConsigneeAddress1) {
        this.ConsigneeAddress1 = ConsigneeAddress1;
    }

    public String getConsigneeAddress2() {
        return ConsigneeAddress2;
    }

    public void setConsigneeAddress2(String ConsigneeAddress2) {
        this.ConsigneeAddress2 = ConsigneeAddress2;
    }

    public String getConsigneeCity() {
        return ConsigneeCity;
    }

    public void setConsigneeCity(String ConsigneeCity) {
        this.ConsigneeCity = ConsigneeCity;
    }

    public String getConsigneeState() {
        return ConsigneeState;
    }

    public void setConsigneeState(String ConsigneeState) {
        this.ConsigneeState = ConsigneeState;
    }

    public String getConsigneeCountry() {
        return ConsigneeCountry;
    }

    public void setConsigneeCountry(String ConsigneeCountry) {
        this.ConsigneeCountry = ConsigneeCountry;
    }

    public String getConsigneeEmail() {
        return ConsigneeEmail;
    }

    public void setConsigneeEmail(String ConsigneeEmail) {
        this.ConsigneeEmail = ConsigneeEmail;
    }

    public String getConsigneePhone() {
        return ConsigneePhone;
    }

    public void setConsigneePhone(String ConsigneePhone) {
        this.ConsigneePhone = ConsigneePhone;
    }

    public String getConsigneePinCode() {
        return ConsigneePinCode;
    }

    public void setConsigneePinCode(String ConsigneePinCode) {
        this.ConsigneePinCode = ConsigneePinCode;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getConsigneeGSTIN() {
        return ConsigneeGSTIN;
    }

    public void setConsigneeGSTIN(String ConsigneeGSTIN) {
        this.ConsigneeGSTIN = ConsigneeGSTIN;
    }

    public String getConsigneePAN() {
        return ConsigneePAN;
    }

    public void setConsigneePAN(String ConsigneePAN) {
        this.ConsigneePAN = ConsigneePAN;
    }

    public String getConsigneeIEC() {
        return ConsigneeIEC;
    }

    public void setConsigneeIEC(String ConsigneeIEC) {
        this.ConsigneeIEC = ConsigneeIEC;
    }

    public int getConsignee_Id() {
        return consignee_Id;
    }

    public void setConsignee_Id(int consignee_Id) {
        this.consignee_Id = consignee_Id;
    }
    
}
