package com.nvoccapi.nvoccapibackend.model;

public class CommodityDetails {
    private Integer commodityId;
    private String commodityName;
    private String commodityimocode;
    private String commodityUnoCode;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityUnoCode() {
        return commodityUnoCode;
    }

    public void setCommodityUnoCode(String commodityUnoCode) {
        this.commodityUnoCode = commodityUnoCode;
    }

    public String getCommodityimocode() {
        return commodityimocode;
    }

    public void setCommodityimocode(String commodityimocode) {
        this.commodityimocode = commodityimocode;
    }
    
}
