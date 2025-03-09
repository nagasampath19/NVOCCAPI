package com.nvoccapi.nvoccapibackend.model;

public class NotifyDetails {
    private Long notify_id;
    private int user_id;
    private String notify_name;
    private String notify_address;
    private String notify_email;
    private String notify_phone;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Long getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(Long notify_id) {
        this.notify_id = notify_id;
    }

    public String getNotify_name() {
        return notify_name;
    }

    public void setNotify_name(String notify_name) {
        this.notify_name = notify_name;
    }

    public String getNotify_address() {
        return notify_address;
    }

    public void setNotify_address(String notify_address) {
        this.notify_address = notify_address;
    }

    public String getNotify_email() {
        return notify_email;
    }

    public void setNotify_email(String notify_email) {
        this.notify_email = notify_email;
    }

    public String getNotify_phone() {
        return notify_phone;
    }

    public void setNotify_phone(String notify_phone) {
        this.notify_phone = notify_phone;
    }
}
