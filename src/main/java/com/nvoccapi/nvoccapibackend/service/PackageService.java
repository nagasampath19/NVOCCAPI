package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.PackageDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PackageDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.PackageDetails;
import com.nvoccapi.nvoccapibackend.repository.PackageRepository;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public void createPackageDetails(PackageDetailsDTO packageDetailsDTO) {
        PackageDetails packageDetails = new PackageDetails();
        packageDetails.setPackageId(packageDetailsDTO.getPackageId());
        packageDetails.setPackageCode(packageDetailsDTO.getPackageCode());
        packageDetails.setDescription(packageDetailsDTO.getDescription());
        packageRepository.savePackageDetails(packageDetails);
    }

     public void deactivatepackageDetails(int packageId) {
        packageRepository.deactivatepackageDetails(packageId); 
    }

     public List<PackageDetails> searchpackageDetails(PackageDetailsSearchDTO searchDTO) {
        return packageRepository.searchPackageDetails(searchDTO);
    }

    public int getpackageDetailsCount() {
        return packageRepository.getpackageDetailsCount();
    }

    public PackageDetails getpackageDetailsById(int packageId) {
        return packageRepository.getpackageDetailsById(packageId);
    }

}