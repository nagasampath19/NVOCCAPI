package com.nvoccapi.nvoccapibackend.model;

public class ShippingLineDetails {
    private Integer shippingLineId;
    private String shippingLineCode;
    private String shippingLineName;
    private String addressLine1;
    private String agentCode;
    private String lineCode;
    private String shippingLineType;

    // Getters and Setters
    public Integer getShippingLineId() {
        return shippingLineId;
    }

    public void setShippingLineId(Integer shippingLineId) {
        this.shippingLineId = shippingLineId;
    }

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

    public String getShippingLineType() {
        return shippingLineType;
    }

    public void setShippingLineType(String shippingLineType) {
        this.shippingLineType = shippingLineType;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }
}