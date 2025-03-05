package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VesselDetailsSearchDTO {
     @NotNull
    @Size(max = 200)
    private String vesselname;

    @Size(max = 100)
    private String vesselimocode;

    private String vesselcallsign;

    public String getVesselname() {
        return vesselname;
    }

    public void setVesselname(String vesselname) {
        this.vesselname = vesselname;
    }

    public String getVesselimocode() {
        return vesselimocode;
    }

    public void setVesselimocode(String vesselimocode) {
        this.vesselimocode = vesselimocode;
    }

    public String getVesselcallsign() {
        return vesselcallsign;
    }

    public void setVesselcallsign(String vesselcallsign) {
        this.vesselcallsign = vesselcallsign;
    }

}
