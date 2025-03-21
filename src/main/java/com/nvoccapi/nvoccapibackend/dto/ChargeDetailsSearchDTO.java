package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.Size;

public class ChargeDetailsSearchDTO {
    @Size(max = 100, message = "Charge code must not exceed 100 characters")
    private String chargeCode;
    @Size(max = 100, message = "Charge name must not exceed 100 characters")
    private String chargeName;
    @Size(max = 10, message = "Charge currency must not exceed 10 characters")
    private String chargeCurrency;
    @Size(max = 25, message = "Charge type must not exceed 25 characters")
    private String chargeType;

    // Getters and Setters
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

    public String getChargeCurrency() {
        return chargeCurrency;
    }

    public void setChargeCurrency(String chargeCurrency) {
        this.chargeCurrency = chargeCurrency;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }
}
