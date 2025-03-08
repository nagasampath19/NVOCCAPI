package com.nvoccapi.nvoccapibackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ShippingLineDetailsDTO;
import com.nvoccapi.nvoccapibackend.service.ShippingLineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/ShippingLine")
public class ShippingLineController {

    @Autowired
    private ShippingLineService shippingLineService;

    @PostMapping("/create")
    public int createShippingLine(@Valid @RequestBody ShippingLineDetailsDTO shippingLineDetailsDTO) {
        return shippingLineService.createShippingLineDetails(shippingLineDetailsDTO);
    }
}