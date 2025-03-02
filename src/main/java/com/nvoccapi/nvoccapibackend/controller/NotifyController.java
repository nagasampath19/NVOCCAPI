package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.UserBLDTO;
import com.nvoccapi.nvoccapibackend.model.NotifyDetails;
import com.nvoccapi.nvoccapibackend.service.NotifyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blapi/Notify")
public class NotifyController {
     @Autowired
    private NotifyService notifyService;

    @PostMapping("/create")
    public int addNotifyDetails(@Valid @RequestBody NotifyDetailsDTO notifyDetailsDTO) {
        return notifyService.createNotifyDetails(notifyDetailsDTO);
    }

    @PostMapping("/getNotifyDetails")
    public List<NotifyDetails> getNotifyDetails(@RequestBody UserBLDTO userBLDTO) {
        Long blId = userBLDTO.getBl_id();
        Integer userId = userBLDTO.getUser_id();
        return notifyService.getNotifyDetails(blId, userId);
    }
}
