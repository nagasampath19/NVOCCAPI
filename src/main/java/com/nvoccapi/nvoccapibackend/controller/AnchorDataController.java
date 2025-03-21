package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.CommodityDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.CommodityDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.PackageDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PackageDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.PortDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PortDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.ShippingLineDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ShippinglineDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.VesselDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.VesselDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CommodityDetails;
import com.nvoccapi.nvoccapibackend.model.CountryFlags;
import com.nvoccapi.nvoccapibackend.model.PackageDetails;
import com.nvoccapi.nvoccapibackend.model.PortDetails;
import com.nvoccapi.nvoccapibackend.model.ShippingLineDetails;
import com.nvoccapi.nvoccapibackend.model.VesselDetails;
import com.nvoccapi.nvoccapibackend.service.AnchorService;
import com.nvoccapi.nvoccapibackend.service.CommodityService;
import com.nvoccapi.nvoccapibackend.service.PackageService;
import com.nvoccapi.nvoccapibackend.service.ShippingLineService;
import com.nvoccapi.nvoccapibackend.service.VesselService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/anchordata")
public class AnchorDataController {

    @Autowired
    private AnchorService anchorService;
    
    @Autowired
    private VesselService vesselService;

    @Autowired
    private PackageService packageService;

    @Autowired
    private ShippingLineService shippinglineService;

    @Autowired
    private CommodityService commodityService;

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

    @PostMapping("/savepackagedetails")
    public void createPackage(@Valid @RequestBody PackageDetailsDTO packageDetailsDTO) {
        packageService.createPackageDetails(packageDetailsDTO);
    }

    @PostMapping("/deactivatepackagedetails")
    public void deactivatepackageDetails(@RequestBody Map<String, Integer> request) {
        Integer packageid = request.get("packageid");
        packageService.deactivatepackageDetails(packageid);
    }

    @PostMapping("/searchpackagedetails")
    public List<PackageDetails> searchpackageDetails(@Valid @RequestBody PackageDetailsSearchDTO searchDTO) {
        return packageService.searchpackageDetails(searchDTO);
    }

    @PostMapping("/packagedetailscount")
    public int getpackageDetailsCount() {
        return packageService.getpackageDetailsCount();
    }

    @PostMapping("/getpackagedetailsbyid")
    public PackageDetails getpackageDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer packageid = request.get("packageid");
        return packageService.getpackageDetailsById(packageid);
    }

    @PostMapping("/saveshippinglinedetails")
    public void createshippingline(@Valid @RequestBody ShippingLineDetailsDTO shippinglineDetailsDTO) {
        shippinglineService.createshippinglineDetails(shippinglineDetailsDTO);
    }

    @PostMapping("/deactivateshippinglinedetails")
    public void deactivateshippinglineDetails(@RequestBody Map<String, Integer> request) {
        Integer shippinglineid = request.get("shippinglineid");
        shippinglineService.deactivateshippinglineDetails(shippinglineid);
    }

    @PostMapping("/searchshippinglinedetails")
    public List<ShippingLineDetails> searchshippinglineDetails(@Valid @RequestBody ShippinglineDetailsSearchDTO searchDTO) {
        return shippinglineService.searchshippinglineDetails(searchDTO);
    }

    @PostMapping("/shippinglinedetailscount")
    public int getshippinglineDetailsCount() {
        return shippinglineService.getshippinglineDetailsCount();
    }

    @PostMapping("/getshippinglinedetailsbyid")
    public ShippingLineDetails getshippinglineDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer shippinglineid = request.get("shippinglineid");
        return shippinglineService.getshippinglineDetailsById(shippinglineid);
    }


    @PostMapping("/savecommoditydetails")
    public void createcommodity(@Valid @RequestBody CommodityDetailsDTO commodityDetailsDTO) {
        commodityService.createcommodityDetails(commodityDetailsDTO);
    }

    @PostMapping("/deactivatecommoditydetails")
    public void deactivatecommodityDetails(@RequestBody Map<String, Integer> request) {
        Integer commodityid = request.get("commodity_id");
        commodityService.deactivatecommodityDetails(commodityid);
    }

    @PostMapping("/searchcommoditydetails")
    public List<CommodityDetails> searchcommodityDetails(@Valid @RequestBody CommodityDetailsSearchDTO searchDTO) {
        return commodityService.searchcommodityDetails(searchDTO);
    }

    @PostMapping("/commoditydetailscount")
    public int getcommodityDetailsCount() {
        return commodityService.getcommodityDetailsCount();
    }

    @PostMapping("/getcommoditydetailsbyid")
    public CommodityDetails getcommodityDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer commodityid = request.get("commodity_id");
        return commodityService.getcommodityDetailsById(commodityid);
    }


}
