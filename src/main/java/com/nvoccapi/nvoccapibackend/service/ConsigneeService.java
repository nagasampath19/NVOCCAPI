package com.nvoccapi.nvoccapibackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ConsigneeDetails;
import com.nvoccapi.nvoccapibackend.repository.ConsigneeRepository;

@Service
public class ConsigneeService {

    @Autowired
    private ConsigneeRepository ConsigneeRepository;

    public int createConsigneeDetails(ConsigneeDetailsDTO ConsigneeDetailsDTO) {
        ConsigneeDetails ConsigneeDetails = new ConsigneeDetails();
        // Map fields from DTO to entity
        
        ConsigneeDetails.setUser_id(ConsigneeDetailsDTO.getUser_id());
        ConsigneeDetails.setBL_ID(ConsigneeDetailsDTO.getBl_id());
        ConsigneeDetails.setConsigneeName(ConsigneeDetailsDTO.getConsigneeName());
        ConsigneeDetails.setConsigneeAddress1(ConsigneeDetailsDTO.getConsigneeAddress1());
        ConsigneeDetails.setConsigneeAddress2(ConsigneeDetailsDTO.getConsigneeAddress2());
        ConsigneeDetails.setConsigneeCity(ConsigneeDetailsDTO.getConsigneeCity());
        ConsigneeDetails.setConsigneeState(ConsigneeDetailsDTO.getConsigneeState());
        ConsigneeDetails.setConsigneeCountry(ConsigneeDetailsDTO.getConsigneeCountry());
        ConsigneeDetails.setConsigneeEmail(ConsigneeDetailsDTO.getConsigneeEmail());
        ConsigneeDetails.setConsigneePhone(ConsigneeDetailsDTO.getConsigneePhone());
        ConsigneeDetails.setConsigneePinCode(ConsigneeDetailsDTO.getConsigneePinCode());
        ConsigneeDetails.setConsigneeRegNo(ConsigneeDetailsDTO.getConsigneeRegNo());
        ConsigneeDetails.setConsigneeTINNo(ConsigneeDetailsDTO.getConsigneeTiNNO());
        

        return ConsigneeRepository.saveConsigneeDetails(ConsigneeDetails);
    }
}
