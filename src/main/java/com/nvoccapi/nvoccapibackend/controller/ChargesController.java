package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ChargeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.ChargesDetailsDTO;
import com.nvoccapi.nvoccapibackend.model.ChargeDetails;
import com.nvoccapi.nvoccapibackend.service.ChargesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Anchordata/Charges")
public class ChargesController {
    @Autowired
    private ChargesService chargesService;

    @PostMapping("/savechargesdetails")
    public int saveCharges(@Valid @RequestBody ChargesDetailsDTO ChargesDetailsDTO) {
        return chargesService.createChargesDetails(ChargesDetailsDTO);
    }
    @PostMapping("/deactivateChargesdetails")
    public void deactivateChargesDetails(@RequestBody Map<String, Integer> request) {
        Integer Charges_id = request.get("Charges_id");
        chargesService.deactivateChargesDetails(Charges_id);
    }

    @PostMapping("/searchChargesdetails")
    public List<ChargeDetails> searchChargesDetails(@Valid @RequestBody ChargeDetailsSearchDTO searchDTO) {
        return chargesService.searchChargesDetails(searchDTO);
    }

    @PostMapping("/Chargesdetailscount")
    public int getChargesDetailsCount(@RequestBody Map<String, Integer> request) {
        Integer user_id = request.get("user_id");
        return chargesService.getChargesDetailsCount(user_id);
    }

    @PostMapping("/getChargesdetailsbyid")
    public ChargeDetails getChargesDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer Charges_id = request.get("Charges_id");
        return chargesService.getChargesDetailsById(Charges_id);
    }
}
