package com.nvoccapi.nvoccapibackend.dto;

public class ConsigneeDetailsSearchDTO {
    private String consigneename;
    private String consigneeemail;
    private String consigneephone;
    private String consigneePAN;
    private String consigneeIEC;

    public String getConsigneename() {
        return consigneename;
    }

    public void setConsigneename(String consigneename) {
        this.consigneename = consigneename;
    }

    public String getConsigneeemail() {
        return consigneeemail;
    }

    public void setConsigneeemail(String consigneeemail) {
        this.consigneeemail = consigneeemail;
    }

    public String getConsigneephone() {
        return consigneephone;
    }

    public void setConsigneephone(String consigneephone) {
        this.consigneephone = consigneephone;
    }

    public String getConsigneeIEC() {
        return consigneeIEC;
    }

    public void setConsigneeIEC(String consigneeIEC) {
        this.consigneeIEC = consigneeIEC;
    }

    public String getConsigneePAN() {
        return consigneePAN;
    }

    public void setConsigneePAN(String consigneePAN) {
        this.consigneePAN = consigneePAN;
    }
}
