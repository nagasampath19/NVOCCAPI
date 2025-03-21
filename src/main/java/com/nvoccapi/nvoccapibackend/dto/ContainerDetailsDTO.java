package com.nvoccapi.nvoccapibackend.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContainerDetailsDTO {
    @NotNull
    private int user_id;

    private Integer container_id;

    @NotNull
    @Size(max = 25, message = "Container number cannot exceed 25 characters")
    private String container_number;

    @NotNull
    private int container_sizeid;

    @NotNull
    private int container_typeid;

    @Size(max = 100, message = "Container agent cannot exceed 100 characters")
    private String container_agent;

    private Date container_purchasedate;

    @Size(max = 4, message = "Container make year cannot exceed 4 characters")
    private String container_makeyear;

    @Size(max = 15, message = "Container hire cannot exceed 15 characters")
    private String container_hire;

    private Date container_hiredate;

    @Size(max = 50, message = "Container inventory type cannot exceed 50 characters")
    private String container_inventorytype;

    private int container_locationid;

    @Size(max = 5, message = "Container currency cannot exceed 5 characters")
    private String container_currency;

    private double container_amount;

    @Size(max = 5, message = "Container free days cannot exceed 5 characters")
    private String container_freedays;

    private double container_pickupcharge;

    private double container_pickupcredit;

    private Date container_leasepurchsestartdate;

    private Date container_leasepurchseenddate;

    private String container_offhirelocsold;

    private Date container_offhirelocsolddate;

    public String getContainer_number() {
        return container_number;
    }

    public void setContainer_number(String container_number) {
        this.container_number = container_number;
    }

    public int getContainer_sizeid() {
        return container_sizeid;
    }

    public void setContainer_sizeid(int container_sizeid) {
        this.container_sizeid = container_sizeid;
    }

    public int getContainer_typeid() {
        return container_typeid;
    }

    public void setContainer_typeid(int container_typeid) {
        this.container_typeid = container_typeid;
    }

    public String getContainer_agent() {
        return container_agent;
    }

    public void setContainer_agent(String container_agent) {
        this.container_agent = container_agent;
    }

    public Date getContainer_purchasedate() {
        return container_purchasedate;
    }

    public void setContainer_purchasedate(Date container_purchasedate) {
        this.container_purchasedate = container_purchasedate;
    }

    public String getContainer_makeyear() {
        return container_makeyear;
    }

    public void setContainer_makeyear(String container_makeyear) {
        this.container_makeyear = container_makeyear;
    }

    public String getContainer_hire() {
        return container_hire;
    }

    public void setContainer_hire(String container_hire) {
        this.container_hire = container_hire;
    }

    public Date getContainer_hiredate() {
        return container_hiredate;
    }

    public void setContainer_hiredate(Date container_hiredate) {
        this.container_hiredate = container_hiredate;
    }

    public String getContainer_inventorytype() {
        return container_inventorytype;
    }

    public void setContainer_inventorytype(String container_inventorytype) {
        this.container_inventorytype = container_inventorytype;
    }

    public int getContainer_locationid() {
        return container_locationid;
    }

    public void setContainer_locationid(int container_locationid) {
        this.container_locationid = container_locationid;
    }

    public String getContainer_currency() {
        return container_currency;
    }

    public void setContainer_currency(String container_currency) {
        this.container_currency = container_currency;
    }

    public double getContainer_amount() {
        return container_amount;
    }

    public void setContainer_amount(double container_amount) {
        this.container_amount = container_amount;
    }

    public String getContainer_freedays() {
        return container_freedays;
    }

    public void setContainer_freedays(String container_freedays) {
        this.container_freedays = container_freedays;
    }

    public double getContainer_pickupcharge() {
        return container_pickupcharge;
    }

    public void setContainer_pickupcharge(double container_pickupcharge) {
        this.container_pickupcharge = container_pickupcharge;
    }

    public double getContainer_pickupcredit() {
        return container_pickupcredit;
    }

    public void setContainer_pickupcredit(double container_pickupcredit) {
        this.container_pickupcredit = container_pickupcredit;
    }

    public Date getContainer_leasepurchsestartdate() {
        return container_leasepurchsestartdate;
    }

    public void setContainer_leasepurchsestartdate(Date container_leasepurchsestartdate) {
        this.container_leasepurchsestartdate = container_leasepurchsestartdate;
    }

    public Date getContainer_leasepurchseenddate() {
        return container_leasepurchseenddate;
    }

    public void setContainer_leasepurchseenddate(Date container_leasepurchseenddate) {
        this.container_leasepurchseenddate = container_leasepurchseenddate;
    }

    public String getContainer_offhirelocsold() {
        return container_offhirelocsold;
    }

    public void setContainer_offhirelocsold(String container_offhirelocsold) {
        this.container_offhirelocsold = container_offhirelocsold;
    }

    public Date getContainer_offhirelocsolddate() {
        return container_offhirelocsolddate;
    }

    public void setContainer_offhirelocsolddate(Date container_offhirelocsolddate) {
        this.container_offhirelocsolddate = container_offhirelocsolddate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Integer getContainer_id() {
        return container_id;
    }

    public void setContainer_id(Integer container_id) {
        this.container_id = container_id;
    }
}