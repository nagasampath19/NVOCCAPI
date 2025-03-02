package com.nvoccapi.nvoccapibackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ShipperDetails;
import com.nvoccapi.nvoccapibackend.repository.ShipperRepository;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository ShipperRepository;

    public int createShipperDetails(ShipperDetailsDTO ShipperDetailsDTO) {
        ShipperDetails ShipperDetails = new ShipperDetails();
        // Map fields from DTO to entity
        ShipperDetails.setUser_id(ShipperDetailsDTO.getUser_id());
        ShipperDetails.setShipperName(ShipperDetailsDTO.getShipperName());
        ShipperDetails.setShipperAddress1(ShipperDetailsDTO.getShipperAddress1());
        ShipperDetails.setShipperAddress2(ShipperDetailsDTO.getShipperAddress2());
        ShipperDetails.setShipperCity(ShipperDetailsDTO.getShipperCity());
        ShipperDetails.setShipperState(ShipperDetailsDTO.getShipperState());
        ShipperDetails.setShipperCountry(ShipperDetailsDTO.getShipperCountry());
        ShipperDetails.setShipperEmail(ShipperDetailsDTO.getShipperEmail());
        ShipperDetails.setShipperPhone(ShipperDetailsDTO.getShipperPhone());
        ShipperDetails.setShipperPinCode(ShipperDetailsDTO.getShipperPinCode());
        ShipperDetails.setShipperCIN(ShipperDetailsDTO.getShipperCIN());

        return ShipperRepository.saveShipperDetails(ShipperDetails);
    }
}
