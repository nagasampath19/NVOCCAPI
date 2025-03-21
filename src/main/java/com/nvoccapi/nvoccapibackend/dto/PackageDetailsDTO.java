package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PackageDetailsDTO {

    @NotEmpty(message = "Package code is required")
    @Size(max = 50, message = "Package code must be at most 50 characters")
    private String packageCode;

    @NotEmpty(message = "Description is required")
    @Size(max = 200, message = "Description must be at most 200 characters")
    private String description;

    private Integer packageId;

    // Getters and Setters
    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

   
}