package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.PortDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PortDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.VesselDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.VesselDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CountryFlags;
import com.nvoccapi.nvoccapibackend.model.PortDetails;
import com.nvoccapi.nvoccapibackend.model.VesselDetails;
import com.nvoccapi.nvoccapibackend.service.AnchorService;
import com.nvoccapi.nvoccapibackend.service.VesselService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/anchordata")
public class AnchorDataController {

    @Autowired
    private AnchorService anchorService;
    
    @Autowired
    private VesselService vesselService;

    @PostMapping("/saveportdetails")
    public int saveportdetails(@Valid @RequestBody PortDetailsDTO portDetailsDTO) {
        return anchorService.savePortDetails(portDetailsDTO);
    }

    @PostMapping("/deactivateportdetails")
    public void deactivatePortDetails(@RequestBody Map<String, Integer> request) {
        Integer port_id = request.get("port_id");
        anchorService.deactivatePortDetails(port_id);
    }

    @PostMapping("/searchportdetails")
    public List<PortDetails> searchPortDetails(@Valid @RequestBody PortDetailsSearchDTO searchDTO) {
        return anchorService.searchPortDetails(searchDTO);
    }

    @PostMapping("/portdetailscount")
    public int getPortDetailsCount() {
        return anchorService.getPortDetailsCount();
    }

    @PostMapping("/getportdetailsbyid")
    public PortDetails getPortDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer port_id = request.get("port_id");
        return anchorService.getPortDetailsById(port_id);
    }

    @PostMapping("/countries")
    public List<CountryFlags> getAllCountries() {
        return vesselService.getAllCountries();
    }

    @PostMapping("/savevesseldetails")
    public void saveVesselDetails(@Valid @RequestBody VesselDetailsDTO vesselDetailsDTO) {
        vesselService.saveVesselDetails(vesselDetailsDTO);
    }

    @PostMapping("/deactivatevesseldetails")
    public void deactivateVesselDetails(@RequestBody Map<String, Integer> request) {
        Integer vesselid = request.get("vesselid");
        vesselService.deactivateVesselDetails(vesselid);
    }

    @PostMapping("/searchvesseldetails")
    public List<VesselDetails> searchVesselDetails(@Valid @RequestBody VesselDetailsSearchDTO searchDTO) {
        return vesselService.searchVesselDetails(searchDTO);
    }

    @PostMapping("/vessledetailscount")
    public int getVesselDetailsCount() {
        return vesselService.getVesselDetailsCount();
    }

    @PostMapping("/getvesseldetailsbyid")
    public VesselDetails getVesselDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer vesselid = request.get("vesselid");
        return vesselService.getVesselDetailsById(vesselid);
    }

}
