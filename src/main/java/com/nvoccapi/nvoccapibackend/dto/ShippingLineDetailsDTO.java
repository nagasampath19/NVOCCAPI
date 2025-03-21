package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ShippingLineDetailsDTO {

    private Integer shippingLineId;

    @NotEmpty(message = "Shipping Line Code is required")
    @Size(max = 50, message = "Shipping Line Code must be at most 50 characters")
    private String shippingLineCode;

    @NotEmpty(message = "Shipping Line Name is required")
    @Size(max = 200, message = "Shipping Line Name must be at most 100 characters")
    private String shippingLineName;

    @NotEmpty(message = "Address Line 1 is required")
    @Size(max = 500, message = "Address Line 1 must be at most 200 characters")
    private String addressLine1;

    @Size(max = 25, message = "Agent Code must be at most 50 characters")
    private String agentCode;

    @Size(max = 25, message = "Line Code must be at most 50 characters")
    private String lineCode;

    @NotEmpty(message = "Shipping Line Type is required")
    private String shippingLineType;

    
    public String getShippingLineCode() {
        return shippingLineCode;
    }

    public void setShippingLineCode(String shippingLineCode) {
        this.shippingLineCode = shippingLineCode;
    }

    public String getShippingLineName() {
        return shippingLineName;
    }

    public void setShippingLineName(String shippingLineName) {
        this.shippingLineName = shippingLineName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getShippingLineType() {
        return shippingLineType;
    }

    public void setShippingLineType(String shippingLineType) {
        this.shippingLineType = shippingLineType;
    }

    public Integer getShippingLineId() {
        return shippingLineId;
    }

    public void setShippingLineId(Integer shippingLineId) {
        this.shippingLineId = shippingLineId;
    }
}