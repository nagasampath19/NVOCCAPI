package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ShippingLineDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ShippinglineDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ShippingLineDetails;
import com.nvoccapi.nvoccapibackend.repository.ShippingLineRepository;

@Service
public class ShippingLineService {

    @Autowired
    private ShippingLineRepository shippingLineRepository;

    public void createshippinglineDetails(ShippingLineDetailsDTO shippingLineDetailsDTO) {
        ShippingLineDetails shippingLineDetails = new ShippingLineDetails();
        shippingLineDetails.setShippingLineId(shippingLineDetailsDTO.getShippingLineId());
        shippingLineDetails.setShippingLineCode(shippingLineDetailsDTO.getShippingLineCode());
        shippingLineDetails.setShippingLineName(shippingLineDetailsDTO.getShippingLineName());
        shippingLineDetails.setAddressLine1(shippingLineDetailsDTO.getAddressLine1());
        shippingLineDetails.setAgentCode(shippingLineDetailsDTO.getAgentCode());
        shippingLineDetails.setLineCode(shippingLineDetailsDTO.getLineCode());
        shippingLineDetails.setShippingLineType(shippingLineDetailsDTO.getShippingLineType());

        shippingLineRepository.saveShippingLineDetails(shippingLineDetails);
    }

     public void deactivateshippinglineDetails(int shippinglineId) {
        shippingLineRepository.deactivateshippinglineDetails(shippinglineId); 
    }

     public List<ShippingLineDetails> searchshippinglineDetails(ShippinglineDetailsSearchDTO searchDTO) {
        return shippingLineRepository.searchshippinglineDetails(searchDTO);
    }

    public int getshippinglineDetailsCount() {
        return shippingLineRepository.getshippinglineDetailsCount();
    }

    public ShippingLineDetails getshippinglineDetailsById(int shippinglineId) {
        return shippingLineRepository.getshippinglineDetailsById(shippinglineId);
    }
}