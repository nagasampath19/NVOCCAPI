package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ChargesDetailsDTO {
    private Integer chargeId;
    private Integer user_id;
    @NotEmpty(message = "Charge code must not be empty")
    @Size(max = 100, message = "Charge code must not exceed 100 characters")
    private String chargeCode;
    @NotEmpty(message = "Charge name must not be empty")
    @Size(max = 100, message = "Charge name must not exceed 100 characters")
    private String chargeName;
    @Size(max = 25, message = "Charge ledger must not exceed 25 characters")
    private String chargeledger;
    @Size(max = 10, message = "Charge currency must not exceed 10 characters")
    private String chargecurrency;
    @Size(max = 25, message = "Charge type must not exceed 25 characters")
    private String chargetype;
    @NotEmpty(message = "Charge GST must not be empty")
    @Size(max = 5, message = "Charge GST must not exceed 5 characters")
    private String chargegst;
    @Size(max = 5, message = "Charge VAT must not exceed 5 characters")
    private String chargevat;
    @Size(max = 5, message = "Charge formula must not exceed 5 characters")
    private String chargeformula;
    @Size(max = 10, message = "Charge limit must not exceed 10 characters")
    private String chargelimit;
    @Size(max = 10, message = "Charge percentage must not exceed 10 characters")
    private String chargepercentage;
    @Size(max = 10, message = "Charge SAC code must not exceed 10 characters")
    private String chargesaccode;
    @Size(max = 5, message = "Charge GST percentage must not exceed 5 characters")
    private String chargegstpercentage;

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeledger() {
        return chargeledger;
    }

    public void setChargeledger(String chargeledger) {
        this.chargeledger = chargeledger;
    }

    public String getChargecurrency() {
        return chargecurrency;
    }

    public void setChargecurrency(String chargecurrency) {
        this.chargecurrency = chargecurrency;
    }

    public String getChargetype() {
        return chargetype;
    }

    public void setChargetype(String chargetype) {
        this.chargetype = chargetype;
    }

    public String getChargegst() {
        return chargegst;
    }

    public void setChargegst(String chargegst) {
        this.chargegst = chargegst;
    }

    public String getChargevat() {
        return chargevat;
    }

    public void setChargevat(String chargevat) {
        this.chargevat = chargevat;
    }

    public String getChargeformula() {
        return chargeformula;
    }

    public void setChargeformula(String chargeformula) {
        this.chargeformula = chargeformula;
    }

    public String getChargelimit() {
        return chargelimit;
    }

    public void setChargelimit(String chargelimit) {
        this.chargelimit = chargelimit;
    }

    public String getChargepercentage() {
        return chargepercentage;
    }

    public void setChargepercentage(String chargepercentage) {
        this.chargepercentage = chargepercentage;
    }

    public String getChargesaccode() {
        return chargesaccode;
    }

    public void setChargesaccode(String chargesaccode) {
        this.chargesaccode = chargesaccode;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getChargegstpercentage() {
        return chargegstpercentage;
    }

    public void setChargegstpercentage(String chargegstpercentage) {
        this.chargegstpercentage = chargegstpercentage;
    }

}
