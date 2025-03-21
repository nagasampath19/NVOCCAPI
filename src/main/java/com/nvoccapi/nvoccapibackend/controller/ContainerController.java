package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.ContainerDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ContainerDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.ContainerSizeDTO;
import com.nvoccapi.nvoccapibackend.model.ContainerDetails;
import com.nvoccapi.nvoccapibackend.model.ContainerSize;
import com.nvoccapi.nvoccapibackend.service.ContainerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Container")
public class ContainerController {
    @Autowired
    private ContainerService containerService;

    @PostMapping("/savecontainerdetails")
    public int saveContainerDetails(@Valid @RequestBody ContainerDetailsDTO containerDetailsDTO) {
        if (containerDetailsDTO.getContainer_id() == null) {
            containerDetailsDTO.setContainer_id(0);
        }
        return containerService.createContainerDetails(containerDetailsDTO);
    }

    @PostMapping("/deactivatecontainerdetails")
    public void deactivateContainerDetails(@RequestBody Map<String, Integer> request) {
        Integer container_id = request.get("container_id");
        containerService.deactivateContainerDetails(container_id);
    }

    @PostMapping("/searchContainerdetails")
    public List<ContainerDetails> searchContainerDetails(@Valid @RequestBody ContainerDetailsSearchDTO searchDTO) {
        return containerService.searchContainerDetails(searchDTO);
    }

    @PostMapping("/Containerdetailscount")
    public int getContainerDetailsCount(@RequestBody Map<String, Integer> request) {
        Integer user_id = request.get("user_id");
        return containerService.getContainerDetailsCount(user_id);
    }

    @PostMapping("/getContainerdetailsbyid")
    public ContainerDetails getContainerDetailsById(@RequestBody Map<String, Integer> request) {
        Integer Container_id = request.get("Container_id");
        return containerService.getContainerDetailsById(Container_id);
    }
    @PostMapping("/getcontainersize")
    public List<ContainerSize> getContainerSizes() {
        return containerService.getContainerSizes();
    }
    @PostMapping("/savecontainersize")
    public void saveContainerSize(@Valid @RequestBody ContainerSizeDTO containerSizeDTO) {
        if (containerSizeDTO.getContainersize_id() == null) {
            containerSizeDTO.setContainersize_id(0);
        }
        containerService.SaveContainerSize(containerSizeDTO);
    }
}
