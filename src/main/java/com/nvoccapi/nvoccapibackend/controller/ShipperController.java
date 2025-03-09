package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ShipperDetails;
import com.nvoccapi.nvoccapibackend.service.ShipperService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Shipper")
public class ShipperController {

    @Autowired
    private ShipperService ShipperService;
    @PostMapping("/create")
    public int createShipper(@Valid @RequestBody ShipperDetailsDTO shipperDetailsDTO) {
        return ShipperService.createShipperDetails(shipperDetailsDTO);
    }
    @PostMapping("/deactivateshipperdetails")
    public void deactivateShipperDetails(@RequestBody Map<String, Integer> request) {
        Integer shipper_id = request.get("shipper_id");
        ShipperService.deactivateShipperDetails(shipper_id);
    }

    @PostMapping("/searchshipperdetails")
    public List<ShipperDetails> searchShipperDetails(@Valid @RequestBody ShipperDetailsSearchDTO searchDTO) {
        return ShipperService.searchShipperDetails(searchDTO);
    }

    @PostMapping("/shipperdetailscount")
    public int getShipperDetailsCount() {
        return ShipperService.getShipperDetailsCount();
    }

    @PostMapping("/getshipperdetailsbyid")
    public ShipperDetails getShipperDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer shipper_id = request.get("shipper_id");
        return ShipperService.getShipperDetailsById(shipper_id);
    }
}
