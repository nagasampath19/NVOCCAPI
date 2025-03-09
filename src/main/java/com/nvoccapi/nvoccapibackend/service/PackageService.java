package com.nvoccapi.nvoccapibackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.PackageDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.PackageDetails;
import com.nvoccapi.nvoccapibackend.repository.PackageRepository;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public int createPackageDetails(PackageDetailsDTO packageDetailsDTO) {
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setPackageCode(packageDetailsDTO.getPackageCode());
        packageDetails.setDescription(packageDetailsDTO.getDescription());

        return packageRepository.savePackageDetails(packageDetails);
    }
}