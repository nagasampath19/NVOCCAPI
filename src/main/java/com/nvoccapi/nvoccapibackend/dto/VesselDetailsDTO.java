package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VesselDetailsDTO {

    private Integer vesselid;

    @NotNull
    @Size(max = 200)
    private String vesselname;

    @Size(max = 100)
    private String vesselimocode;

    @Size(max = 100)
    private String vesselflag;

    @Size(max = 50)
    private String vesselcallsign;

    // Getters and Setters
    public Integer getvesselid() {
        return vesselid;
    }

    public void setvesselid(Integer vesselid) {
        this.vesselid = vesselid;
    }

    public String getvesselname() {
        return vesselname;
    }

    public void setvesselname(String vesselname) {
        this.vesselname = vesselname;
    }

    public String getvesselimocode() {
        return vesselimocode;
    }

    public void setvesselimocode(String vesselimocode) {
        this.vesselimocode = vesselimocode;
    }

    public String getvesselflag() {
        return vesselflag;
    }

    public void setvesselflag(String vesselflag) {
        this.vesselflag = vesselflag;
    }

    public String getvesselcallsign() {
        return vesselcallsign;
    }

    public void setvesselcallsign(String vesselcallsign) {
        this.vesselcallsign = vesselcallsign;
    }
}
