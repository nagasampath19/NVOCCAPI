package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PortDetailsDTO {

    private Integer port_id;

    @Size(max = 100)
    private String portcode;

    @Size(max = 200)
    private String portname;

    @Size(max = 500)
    private String cfsaddress;

    @Size(max = 50)
    private String edicode;

    @Size(max = 50)
    private String jnptcode;

    @Size(max = 50)
    private String nsictgroupcode;

    @Size(max = 50)
    private String gticode;

    @Size(max = 100)
    private String gtigroupname;

    @Size(max = 50)
    private String bmctcode;

    @Size(max = 50)
    private String nsigtcode;

    @NotNull
    private Integer porttype;

    // Getters and Setters
    public Integer getPort_id() {
        return port_id;
    }

    public void setPort_id(Integer port_id) {
        this.port_id = port_id;
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

    public String getCfsaddress() {
        return cfsaddress;
    }

    public void setCfsaddress(String cfsaddress) {
        this.cfsaddress = cfsaddress;
    }

    public String getEdicode() {
        return edicode;
    }

    public void setEdicode(String edicode) {
        this.edicode = edicode;
    }

    public String getJnptcode() {
        return jnptcode;
    }

    public void setJnptcode(String jnptcode) {
        this.jnptcode = jnptcode;
    }

    public String getNsictgroupcode() {
        return nsictgroupcode;
    }

    public void setNsictgroupcode(String nsictgroupcode) {
        this.nsictgroupcode = nsictgroupcode;
    }

    public String getGticode() {
        return gticode;
    }

    public void setGticode(String gticode) {
        this.gticode = gticode;
    }

    public String getGtigroupname() {
        return gtigroupname;
    }

    public void setGtigroupname(String gtigroupname) {
        this.gtigroupname = gtigroupname;
    }

    public String getBmctcode() {
        return bmctcode;
    }

    public void setBmctcode(String bmctcode) {
        this.bmctcode = bmctcode;
    }

    public String getNsigtcode() {
        return nsigtcode;
    }

    public void setNsigtcode(String nsigtcode) {
        this.nsigtcode = nsigtcode;
    }

    public Integer getPorttype() {
        return porttype;
    }

    public void setPorttype(Integer porttype) {
        this.porttype = porttype;
    }
}
