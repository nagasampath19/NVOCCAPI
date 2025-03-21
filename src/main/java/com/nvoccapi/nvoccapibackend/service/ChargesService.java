package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ChargeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.ChargesDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ChargeDetails;
import com.nvoccapi.nvoccapibackend.repository.ChargesRepository;


@Service
public class ChargesService {

    @Autowired
    private ChargesRepository chargesRepository;

    public int createChargesDetails(ChargesDetailsDTO chargesDetailsDTO) {
        ChargeDetails chargeDetails = new ChargeDetails();
        chargeDetails.setChargeId(chargesDetailsDTO.getChargeId());
        chargeDetails.setUser_id(chargesDetailsDTO.getUser_id());
        chargeDetails.setChargeCode(chargesDetailsDTO.getChargeCode());
        chargeDetails.setChargeName(chargesDetailsDTO.getChargeName());
        chargeDetails.setChargeledger(chargesDetailsDTO.getChargeledger());
        chargeDetails.setChargecurrency(chargesDetailsDTO.getChargecurrency());
        chargeDetails.setChargetype(chargesDetailsDTO.getChargetype());
        chargeDetails.setChargegst(chargesDetailsDTO.getChargegst());
        chargeDetails.setChargegstpercentage(chargesDetailsDTO.getChargegstpercentage());
        chargeDetails.setChargevat(chargesDetailsDTO.getChargevat());
        chargeDetails.setChargeformula(chargesDetailsDTO.getChargeformula());
        chargeDetails.setChargelimit(chargesDetailsDTO.getChargelimit());
        chargeDetails.setChargepercentage(chargesDetailsDTO.getChargepercentage());
        chargeDetails.setChargesaccode(chargesDetailsDTO.getChargesaccode());
        return chargesRepository.saveChargesDetails(chargeDetails);
    }

     public void deactivateChargesDetails(int charge_Id) {
        chargesRepository.deactivateChargesDetails(charge_Id); 
    }

     public List<ChargeDetails> searchChargesDetails(ChargeDetailsSearchDTO searchDTO) {
        return chargesRepository.searchChargesDetails(searchDTO);
    }

    public int getChargesDetailsCount(int user_id) {
        return chargesRepository.getChargesDetailsCount(user_id);
    }

    public ChargeDetails getChargesDetailsById(int charge_Id) {
        return chargesRepository.getChargesDetailsById(charge_Id);
    }
}
