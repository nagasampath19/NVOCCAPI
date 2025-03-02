package com.nvoccapi.nvoccapibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ConsigneeDetailsDTO;
import com.nvoccapi.nvoccapibackend.service.ConsigneeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Consignee")
public class ConsigneeController {

    @Autowired
    private ConsigneeService consigneeService;



    @PostMapping("/create")
    public int createShipping(@Valid @RequestBody ConsigneeDetailsDTO consigneeDetailsDTO) {
        return consigneeService.createConsigneeDetails(consigneeDetailsDTO);
    }
}
