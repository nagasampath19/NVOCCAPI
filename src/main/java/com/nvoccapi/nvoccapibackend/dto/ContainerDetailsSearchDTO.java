package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ContainerDetailsSearchDTO {
    @NotNull
    @Size(max = 25, message = "Container number cannot exceed 25 characters")
    private String container_number;

    private int container_sizeid;

    private int container_typeid;

    // Getters and Setters
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
}
