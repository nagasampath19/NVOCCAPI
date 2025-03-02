package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NotifyDetailsDTO {
    private Long bl_id;
    private int user_id;
    private Long notify_id;
    
    @NotEmpty(message = "Name is required")
    @Size(max = 250, message = "Name must be at most 250 characters")
    private String name;

    @NotEmpty(message = "Address is required")
    @Size(max = 500, message = "Address must be at most 500 characters")
    private String address;

    @Email(message = "Email should be valid")
    @Size(max = 250, message = "Email must be at most 250 characters")
    private String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    @Size(max = 20, message = "Phone number must be at most 20 characters")
    private String phone;

   
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBl_id() {
        return bl_id;
    }

    public void setBl_id(Long bl_id) {
        this.bl_id = bl_id;
    }

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
}
