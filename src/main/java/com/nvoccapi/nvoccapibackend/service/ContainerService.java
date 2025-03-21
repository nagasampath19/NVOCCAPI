package com.nvoccapi.nvoccapibackend.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.ContainerDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.ContainerDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.dto.ContainerSizeDTO;
import com.nvoccapi.nvoccapibackend.model.ContainerDetails;
import com.nvoccapi.nvoccapibackend.model.ContainerSize;
import com.nvoccapi.nvoccapibackend.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    public int createContainerDetails(ContainerDetailsDTO containerDetailsDTO) {
        ContainerDetails containerDetails = new ContainerDetails();
        if (containerDetailsDTO.getContainer_id() == null) {
            containerDetails.setContainer_id(0);
        } else {
            containerDetails.setContainer_id(containerDetailsDTO.getContainer_id());
        }
        containerDetails.setUser_id(containerDetailsDTO.getUser_id());
        containerDetails.setContainer_number(containerDetailsDTO.getContainer_number());
        containerDetails.setContainer_typeid(containerDetailsDTO.getContainer_typeid());
        containerDetails.setContainer_sizeid(containerDetailsDTO.getContainer_sizeid());
        containerDetails.setContainer_agent(containerDetailsDTO.getContainer_agent());
        if (containerDetailsDTO.getContainer_purchasedate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedHireDate = sdf.format(containerDetailsDTO.getContainer_purchasedate());
            containerDetails.setContainer_purchasedate(formattedHireDate);
        }
        containerDetails.setContainer_makeyear(containerDetailsDTO.getContainer_makeyear());
        containerDetails.setContainer_hire(containerDetailsDTO.getContainer_hire());
        if (containerDetailsDTO.getContainer_hiredate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedHireDate = sdf.format(containerDetailsDTO.getContainer_hiredate());
            containerDetails.setContainer_hiredate(formattedHireDate);
        }

        containerDetails.setContainer_inventorytype(containerDetailsDTO.getContainer_inventorytype());
        containerDetails.setContainer_locationid(containerDetailsDTO.getContainer_locationid());
        containerDetails.setContainer_currency(containerDetailsDTO.getContainer_currency());
        containerDetails.setContainer_amount(containerDetailsDTO.getContainer_amount());
        containerDetails.setContainer_freedays(containerDetailsDTO.getContainer_freedays());
        containerDetails.setContainer_pickupcharge(containerDetailsDTO.getContainer_pickupcharge());
        containerDetails.setContainer_pickupcredit(containerDetailsDTO.getContainer_pickupcredit());
        if (containerDetailsDTO.getContainer_leasepurchsestartdate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedHireDate = sdf.format(containerDetailsDTO.getContainer_leasepurchsestartdate());
            containerDetails.setContainer_leasepurchsestartdate(formattedHireDate);
        }
        if (containerDetailsDTO.getContainer_leasepurchseenddate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedHireDate = sdf.format(containerDetailsDTO.getContainer_leasepurchseenddate());
            containerDetails.setContainer_leasepurchseenddate(formattedHireDate);
        }
        containerDetails.setContainer_offhirelocsold(containerDetailsDTO.getContainer_offhirelocsold());
        if (containerDetailsDTO.getContainer_offhirelocsolddate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedHireDate = sdf.format(containerDetailsDTO.getContainer_offhirelocsolddate());
            containerDetails.setContainer_offhirelocsolddate(formattedHireDate);
        }
        return containerRepository.saveContainerDetails(containerDetails);
    }

    public void deactivateContainerDetails(int Container_Id) {
        containerRepository.deactivateContainerDetails(Container_Id);
    }

    public List<ContainerDetails> searchContainerDetails(ContainerDetailsSearchDTO searchDTO) {
        return containerRepository.searchContainerDetails(searchDTO);
    }

    public int getContainerDetailsCount(int user_id) {
        return containerRepository.getContainerDetailsCount(user_id);
    }

    public ContainerDetails getContainerDetailsById(int Container_Id) {
        return containerRepository.getContainerDetailsById(Container_Id);
    }

    public void SaveContainerSize(ContainerSizeDTO containerSizeDTO) {
        ContainerSize containerSize = new ContainerSize();
        if (containerSizeDTO.getContainersize_id() == null) {
            containerSize.setContainersize_id(0);
        } else {
            containerSize.setContainersize_id(containerSizeDTO.getContainersize_id());
        }
        containerSize.setContainersize_type(containerSizeDTO.getContainersize_type());
        containerSize.setContainersize_desc(containerSizeDTO.getContainersize_desc());
        containerSize.setContainersize_isocode(containerSizeDTO.getContainersize_code());
        containerRepository.SaveContainerSize(containerSize);
    }

    public List<ContainerSize> getContainerSizes() {
        return containerRepository.getContainerSizes();
    }
}
