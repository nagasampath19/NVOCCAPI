package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PortDetailsSearchDTO {
     @NotNull
    private Integer porttype;

    @Size(max = 100)
    private String portcode;

    @Size(max = 200)
    private String portname;

    // Getters and Setters
    public Integer getPorttype() {
        return porttype;
    }

    public void setPorttype(Integer porttype) {
        this.porttype = porttype;
    }

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }
}
