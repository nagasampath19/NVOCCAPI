package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;

public class UserBLDTO {
    @NotNull(message = "BL ID is required")
    private Long bl_id;

    @NotNull(message = "User ID is required")
    private Integer user_id;

    // Getters and Setters
    public Long getBl_id() {
        return bl_id;
    }

    public void setBl_id(Long bl_id) {
        this.bl_id = bl_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
