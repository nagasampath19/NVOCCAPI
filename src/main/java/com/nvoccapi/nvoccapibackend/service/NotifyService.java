package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.NotifyDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.NotifyDetails;
import com.nvoccapi.nvoccapibackend.repository.NotifyRepository;

@Service
public class NotifyService {
  @Autowired
    private NotifyRepository notifyRepository;

    public int createNotifyDetails(NotifyDetailsDTO notifyDetailsDTO) {
        NotifyDetails notifyDetails = new NotifyDetails();
        notifyDetails.setNotify_id(notifyDetailsDTO.getNotify_id());
        notifyDetails.setUser_id(notifyDetailsDTO.getUser_id());
        notifyDetails.setNotify_name(notifyDetailsDTO.getName());
        notifyDetails.setNotify_address(notifyDetailsDTO.getAddress());
        notifyDetails.setNotify_email(notifyDetailsDTO.getEmail());
        notifyDetails.setNotify_phone(notifyDetailsDTO.getPhone());
        return notifyRepository.saveNotifyDetails(notifyDetails);
    }

    public List<NotifyDetails> getNotifyDetails(Long blId, Integer userId) {
        return notifyRepository.getNotifyDetails(blId, userId);
    }

    public void deactivateNotifyDetails(int notify_id) {
        notifyRepository.deactivateNotifyDetails(notify_id);
    }

    public int getNotifyDetailsCount(int user_id) {
        return notifyRepository.getNotifyDetailsCount(user_id);
    }

    public NotifyDetails getNotifyDetailsById(int notify_id) {
        return notifyRepository.getNotifyDetailsById(notify_id);
    }

    public List<NotifyDetails> searchNotifyDetails(NotifyDetailsSearchDTO searchDTO) {
        return notifyRepository.searchNotifyDetails(searchDTO);
    }
}
