package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CommodityDetailsDTO {
    private Integer commodity_id;

    @NotEmpty(message = "Commodity name must not be empty")
    @Size(max = 100, message = "Commodity name must not exceed 100 characters")
    private String commodity_name;

    
    @Size(max = 150, message = "Commodity IMO code must not exceed 150 characters")
    private String commodity_imocode;

    
    @Size(max = 50, message = "Commodity UNO code must not exceed 50 characters")
    private String commodity_unocode;

    // Getters and Setters

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

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

    public String getCommodity_unocode() {
        return commodity_unocode;
    }

    public void setCommodity_unocode(String commodity_unocode) {
        this.commodity_unocode = commodity_unocode;
    }
    
     
}
