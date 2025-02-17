package com.nvoccapi.nvoccapibackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ShipperDetails;
import com.nvoccapi.nvoccapibackend.repository.ShipperRepository;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository shippingRepository;

    public int createShippingDetails(ShipperDetailsDTO shippingDetailsDTO) {
        ShipperDetails shippingDetails = new ShipperDetails();
        // Map fields from DTO to entity
        shippingDetails.setUser_id(shippingDetailsDTO.getUser_id());
        shippingDetails.setShipperName(shippingDetailsDTO.getShipperName());
        shippingDetails.setShipperAddress1(shippingDetailsDTO.getShipperAddress1());
        shippingDetails.setShipperAddress2(shippingDetailsDTO.getShipperAddress2());
        shippingDetails.setShipperCity(shippingDetailsDTO.getShipperCity());
        shippingDetails.setShipperState(shippingDetailsDTO.getShipperState());
        shippingDetails.setShipperCountry(shippingDetailsDTO.getShipperCountry());
        shippingDetails.setShipperEmail(shippingDetailsDTO.getShipperEmail());
        shippingDetails.setShipperPhone(shippingDetailsDTO.getShipperPhone());
        shippingDetails.setShipperPinCode(shippingDetailsDTO.getShipperPinCode());
        shippingDetails.setShipperCIN(shippingDetailsDTO.getShipperCIN());

        return shippingRepository.saveShippingDetails(shippingDetails);
    }
}
