package com.nvoccapi.nvoccapibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.PackageDetailsDTO;
import com.nvoccapi.nvoccapibackend.service.PackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Package")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/create")
    public int createPackage(@Valid @RequestBody PackageDetailsDTO packageDetailsDTO) {
        return packageService.createPackageDetails(packageDetailsDTO);
    }
}