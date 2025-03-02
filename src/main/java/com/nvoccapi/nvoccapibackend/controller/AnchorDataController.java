package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.PortDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PortDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.PortDetails;
import com.nvoccapi.nvoccapibackend.service.AnchorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/anchordata")
public class AnchorDataController {

    @Autowired
    private AnchorService anchorService;

    @PostMapping("/saveportdetails")
    public int saveportdetails(@Valid @RequestBody PortDetailsDTO portDetailsDTO) {
        return anchorService.savePortDetails(portDetailsDTO);
    }

    @PostMapping("/deactivateportdetails")
    public void deactivatePortDetails(@RequestBody Map<String, Integer> request) {
        Integer port_id = request.get("port_id");
        anchorService.deactivatePortDetails(port_id);
    }

    @PostMapping("/searchportdetails")
    public List<PortDetails> searchPortDetails(@Valid @RequestBody PortDetailsSearchDTO searchDTO) {
        return anchorService.searchPortDetails(searchDTO);
    }

    @PostMapping("/portdetailscount")
    public int getPortDetailsCount() {
        return anchorService.getPortDetailsCount();
    }

    @PostMapping("/getportdetailsbyid")
    public PortDetails getPortDetailsByID(@RequestBody Map<String, Integer> request) {
        Integer port_id = request.get("port_id");
        return anchorService.getPortDetailsById(port_id);
    }
}
