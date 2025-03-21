package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.Size;

public class CommodityDetailsSearchDTO {

    @Size(max = 100, message = "Commodity name must not exceed 100 characters")
    private String commodity_name;

    @Size(max = 150, message = "Commodity IMO code must not exceed 150 characters")
    private String commodity_imocode;

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_imocode() {
        return commodity_imocode;
    }

    public void setCommodity_imocode(String commodity_imocode) {
        this.commodity_imocode = commodity_imocode;
    }

    
}
