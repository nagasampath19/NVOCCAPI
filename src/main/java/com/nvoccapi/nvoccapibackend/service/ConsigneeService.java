package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ConsigneeDetails;
import com.nvoccapi.nvoccapibackend.repository.ConsigneeRepository;

@Service
public class ConsigneeService {

    @Autowired
    private ConsigneeRepository consigneeRepository;

    public int createConsigneeDetails(ConsigneeDetailsDTO ConsigneeDetailsDTO) {
        ConsigneeDetails consigneeDetails = new ConsigneeDetails();
        // Map fields from DTO to entity
        consigneeDetails.setConsignee_Id(ConsigneeDetailsDTO.getConsignee_Id());
        consigneeDetails.setUser_id(ConsigneeDetailsDTO.getUser_id());
        consigneeDetails.setConsigneeName(ConsigneeDetailsDTO.getConsigneeName());
        consigneeDetails.setConsigneeAddress1(ConsigneeDetailsDTO.getConsigneeAddress1());
        consigneeDetails.setConsigneeAddress2(ConsigneeDetailsDTO.getConsigneeAddress2());
        consigneeDetails.setConsigneeCity(ConsigneeDetailsDTO.getConsigneeCity());
        consigneeDetails.setConsigneeState(ConsigneeDetailsDTO.getConsigneeState());
        consigneeDetails.setConsigneeCountry(ConsigneeDetailsDTO.getConsigneeCountry());
        consigneeDetails.setConsigneeEmail(ConsigneeDetailsDTO.getConsigneeEmail());
        consigneeDetails.setConsigneePhone(ConsigneeDetailsDTO.getConsigneePhone());
        consigneeDetails.setConsigneePinCode(ConsigneeDetailsDTO.getConsigneePinCode());
        consigneeDetails.setConsigneeGSTIN(ConsigneeDetailsDTO.getConsigneeGSTIN());
        consigneeDetails.setConsigneePAN(ConsigneeDetailsDTO.getConsigneePAN());
        consigneeDetails.setConsigneeIEC(ConsigneeDetailsDTO.getConsigneeIEC());
        return consigneeRepository.saveConsigneeDetails(consigneeDetails);
    }

     public void deactivateConsigneeDetails(int consignee_Id) {
        consigneeRepository.deactivateConsigneeDetails(consignee_Id); 
    }

     public List<ConsigneeDetails> searchConsigneeDetails(ConsigneeDetailsSearchDTO searchDTO) {
        return consigneeRepository.searchConsigneeDetails(searchDTO);
    }

    public int getConsigneeDetailsCount(int user_id) {
        return consigneeRepository.getConsigneeDetailsCount(user_id);
    }

    public ConsigneeDetails getConsigneeDetailsById(int consignee_Id) {
        return consigneeRepository.getConsigneeDetailsById(consignee_Id);
    }

}
