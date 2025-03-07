package com.nvoccapi.nvoccapibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsDTO;
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
}
