package com.nvoccapi.nvoccapibackend.model;

public class ShippingLineDetails {
    private int shippingLineId;
    private int userId; // Added user_id field
    private String shippingLineCode;
    private String shippingLineName;
    private String addressLine1;
    private String addressLine2;
    private String agentCode;
    private String lineCode;
    private String shippingLineType;

    // Getters and Setters
    public int getShippingLineId() {
        return shippingLineId;
    }

    public void setShippingLineId(int shippingLineId) {
        this.shippingLineId = shippingLineId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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
}