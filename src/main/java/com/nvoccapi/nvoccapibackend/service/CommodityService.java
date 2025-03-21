package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.CommodityDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.CommodityDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.CommodityDetails;
import com.nvoccapi.nvoccapibackend.repository.CommodityRepository;



@Service
public class CommodityService {
    
    @Autowired
    private CommodityRepository commodityRepository;

    public void createcommodityDetails(CommodityDetailsDTO commodityDetailsDTO) {
        CommodityDetails commodityDetails = new CommodityDetails();
        
        commodityDetails.setCommodityId(commodityDetailsDTO.getCommodity_id());
        commodityDetails.setCommodityName(commodityDetailsDTO.getCommodity_name());
        commodityDetails.setCommodityimocode(commodityDetailsDTO.getCommodity_imocode());
        commodityDetails.setCommodityUnoCode(commodityDetailsDTO.getCommodity_unocode());
        commodityRepository.savecommodityDetails(commodityDetails);
    }

     public void deactivatecommodityDetails(int commodityId) {
        commodityRepository.deactivatecommodityDetails(commodityId); 
    }

     public List<CommodityDetails> searchcommodityDetails(CommodityDetailsSearchDTO searchDTO) {
        return commodityRepository.searchcommodityDetails(searchDTO);
    }

    public int getcommodityDetailsCount() {
        return commodityRepository.getcommodityDetailsCount();
    }

    public CommodityDetails getcommodityDetailsById(int commodityId) {
        return commodityRepository.getcommodityDetailsById(commodityId);
    }
}
