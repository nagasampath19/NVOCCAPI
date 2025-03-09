package com.nvoccapi.nvoccapibackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ShippingLineDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ShippingLineDetails;
import com.nvoccapi.nvoccapibackend.repository.ShippingLineRepository;

@Service
public class ShippingLineService {

    @Autowired
    private ShippingLineRepository shippingLineRepository;

    public int createShippingLineDetails(ShippingLineDetailsDTO shippingLineDetailsDTO) {
        ShippingLineDetails shippingLineDetails = new ShippingLineDetails();
        shippingLineDetails.setUserId(shippingLineDetailsDTO.getUserId());
        shippingLineDetails.setShippingLineCode(shippingLineDetailsDTO.getShippingLineCode());
        shippingLineDetails.setShippingLineName(shippingLineDetailsDTO.getShippingLineName());
        shippingLineDetails.setAddressLine1(shippingLineDetailsDTO.getAddressLine1());
        shippingLineDetails.setAddressLine2(shippingLineDetailsDTO.getAddressLine2());
        shippingLineDetails.setAgentCode(shippingLineDetailsDTO.getAgentCode());
        shippingLineDetails.setLineCode(shippingLineDetailsDTO.getLineCode());
        shippingLineDetails.setShippingLineType(shippingLineDetailsDTO.getShippingLineType());

        return shippingLineRepository.saveShippingLineDetails(shippingLineDetails);
    }
}