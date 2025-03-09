package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.ConsigneeDetails;
import com.nvoccapi.nvoccapibackend.service.ConsigneeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Consignee")
public class ConsigneeController {

    @Autowired
    private ConsigneeService consigneeService;



    @PostMapping("/create")
    public int createConsignee(@Valid @RequestBody ConsigneeDetailsDTO consigneeDetailsDTO) {
        return consigneeService.createConsigneeDetails(consigneeDetailsDTO);
    }
    @PostMapping("/deactivateconsigneedetails")
    public void deactivateConsigneeDetails(@RequestBody Map<String, Integer> request) {
        Integer consignee_id = request.get("consignee_id");
        consigneeService.deactivateConsigneeDetails(consignee_id);
    }

    @PostMapping("/searchconsigneedetails")
    public List<ConsigneeDetails> searchConsigneeDetails(@Valid @RequestBody ConsigneeDetailsSearchDTO searchDTO) {
        return consigneeService.searchConsigneeDetails(searchDTO);
    }

    @PostMapping("/consigneedetailscount")
    public int getConsigneeDetailsCount(@RequestBody Map<String, Integer> request) {
        Integer user_id = request.get("user_id");
        return consigneeService.getConsigneeDetailsCount(user_id);
    }

    @PostMapping("/getconsigneedetailsbyid")
    public ConsigneeDetails getConsigneeDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer consignee_id = request.get("consignee_id");
        return consigneeService.getConsigneeDetailsById(consignee_id);
    }
}
