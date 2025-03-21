package com.nvoccapi.nvoccapibackend.dto;

public class PackageDetailsSearchDTO {
    private String packageCode;
    private String packageDescription;

    // Getters and Setters
    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }
}
