package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ShipperDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ShipperDetails;
import com.nvoccapi.nvoccapibackend.repository.ShipperRepository;

@Service
public class ShipperService {

    @Autowired
    private ShipperRepository ShipperRepository;

    public int createShipperDetails(ShipperDetailsDTO ShipperDetailsDTO) {
        ShipperDetails ShipperDetails = new ShipperDetails();
        ShipperDetails.setShipperid(ShipperDetailsDTO.getShipperid());
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
    public void deactivateShipperDetails(int shipper_Id) {
        ShipperRepository.deactivateShipperDetails(shipper_Id); 
    }

    public List<ShipperDetails> searchShipperDetails(ShipperDetailsSearchDTO searchDTO) {
        return ShipperRepository.searchShipperDetails(searchDTO);
    }

    public int getShipperDetailsCount() {
        return ShipperRepository.getShipperDetailsCount();
    }

    public ShipperDetails getShipperDetailsById(int shipper_Id) {
        return ShipperRepository.getShipperDetailsById(shipper_Id);
    }
}
