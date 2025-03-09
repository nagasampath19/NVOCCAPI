package com.nvoccapi.nvoccapibackend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsSearchDTO;
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

    @PostMapping("/deactivatenotifydetails")
    public void deactivateNotifyDetails(@RequestBody Map<String, Integer> request) {
        Integer notify_id = request.get("notify_id");
        notifyService.deactivateNotifyDetails(notify_id);
    }

    @PostMapping("/searchnotifydetails")
    public List<NotifyDetails> searchNotifyDetails(@Valid @RequestBody NotifyDetailsSearchDTO searchDTO) {
        return notifyService.searchNotifyDetails(searchDTO);
    }

    @PostMapping("/notifydetailscount")
    public int getNotifyDetailsCount(@RequestBody Map<String, Integer> request) {
        Integer user_id = request.get("user_id");
        return notifyService.getNotifyDetailsCount(user_id);
    }

    @PostMapping("/getnotifydetailsbyid")
    public NotifyDetails getNotifyDetailsById(@RequestBody Map<String, Integer> request) {
        Integer notify_id = request.get("notify_id");
        return notifyService.getNotifyDetailsById(notify_id);
    }
}
