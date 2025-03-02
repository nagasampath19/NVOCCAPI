package com.nvoccapi.nvoccapibackend.model;

public class PortDetails {

    private Integer port_id;
    private String portcode;
    private String portname;
    private String cfsaddress;
    private String edicode;
    private String jnptcode;
    private String nsictgroupcode;
    private String gticode;
    private String gtigroupname;
    private String bmctcode;
    private String nsigtcode;
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
