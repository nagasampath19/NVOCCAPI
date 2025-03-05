package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.VesselDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.VesselDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CountryFlags;
import com.nvoccapi.nvoccapibackend.model.VesselDetails;
import com.nvoccapi.nvoccapibackend.repository.VesselRepository;

@Service
public class VesselService {

    @Autowired
    private VesselRepository vesselRepository;

    public List<CountryFlags> getAllCountries() {
        return vesselRepository.getAllCountries();
    }

    public void saveVesselDetails(VesselDetailsDTO vesselDetailsDTO) {
        VesselDetails vesselDetails = new VesselDetails();
        vesselDetails.setVesselid(vesselDetailsDTO.getvesselid());
        vesselDetails.setVesselname(vesselDetailsDTO.getvesselname());
        vesselDetails.setVesselimocode(vesselDetailsDTO.getvesselimocode());
        vesselDetails.setVesselflag(vesselDetailsDTO.getvesselflag());
        vesselDetails.setVesselcallsign(vesselDetailsDTO.getvesselcallsign());
        vesselRepository.saveVesselDetails(vesselDetails);
    }

    public void deactivateVesselDetails(int vesselId) {
        vesselRepository.deactivateVesselDetails(vesselId); 
    }

     public List<VesselDetails> searchVesselDetails(VesselDetailsSearchDTO searchDTO) {
        return vesselRepository.searchVesselDetails(searchDTO);
    }

    public int getVesselDetailsCount() {
        return vesselRepository.getVesselDetailsCount();
    }

    public VesselDetails getVesselDetailsById(int vesselId) {
        return vesselRepository.getVesselDetailsById(vesselId);
    }
}
