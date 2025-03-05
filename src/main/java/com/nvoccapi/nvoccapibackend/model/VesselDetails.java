package com.nvoccapi.nvoccapibackend.model;

public class VesselDetails {
    private Integer vesselid;
    private String vesselname;
    private String vesselimocode;
    private String vesselflag;
    private String vesselcallsign;

    public Integer getVesselid() {
        return vesselid;
    }

    public void setVesselid(Integer vesselid) {
        this.vesselid = vesselid;
    }

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

    public String getVesselflag() {
        return vesselflag;
    }

    public void setVesselflag(String vesselflag) {
        this.vesselflag = vesselflag;
    }

    public String getVesselcallsign() {
        return vesselcallsign;
    }

    public void setVesselcallsign(String vesselcallsign) {
        this.vesselcallsign = vesselcallsign;
    }
    

}