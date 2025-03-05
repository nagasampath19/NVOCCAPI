package com.nvoccapi.nvoccapibackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvoccapi.nvoccapibackend.dto.PortDetailsDTO;
import com.nvoccapi.nvoccapibackend.dto.PortDetailsSearchDTO;
import com.nvoccapi.nvoccapibackend.model.PortDetails;
import com.nvoccapi.nvoccapibackend.repository.AnchorDataRepository;
import com.nvoccapi.nvoccapibackend.repository.VesselRepository;


@Service
public class AnchorService {

    @Autowired
    private AnchorDataRepository anchorDataRepository;

    @Autowired
    private VesselRepository vesselRepository;

    public int savePortDetails(PortDetailsDTO portDetailsDTO) {
        PortDetails portDetails = new PortDetails();
        portDetails.setPort_id(portDetailsDTO.getPort_id());
        portDetails.setPortcode(portDetailsDTO.getPortcode());
        portDetails.setPortname(portDetailsDTO.getPortname());
        portDetails.setCfsaddress(portDetailsDTO.getCfsaddress());
        portDetails.setEdicode(portDetailsDTO.getEdicode());
        portDetails.setJnptcode(portDetailsDTO.getJnptcode());
        portDetails.setNsictgroupcode(portDetailsDTO.getNsictgroupcode());
        portDetails.setGticode(portDetailsDTO.getGticode());
        portDetails.setGtigroupname(portDetailsDTO.getGtigroupname());
        portDetails.setBmctcode(portDetailsDTO.getBmctcode());
        portDetails.setNsigtcode(portDetailsDTO.getNsigtcode());
        portDetails.setPorttype(portDetailsDTO.getPorttype());
        return anchorDataRepository.savePortDetails(portDetails);
    }

    public void deactivatePortDetails(int portId) {
        anchorDataRepository.deactivatePortDetails(portId); 
    }

     public List<PortDetails> searchPortDetails(PortDetailsSearchDTO searchDTO) {
        return anchorDataRepository.searchPortDetails(searchDTO);
    }

    public int getPortDetailsCount() {
        return anchorDataRepository.getPortDetailsCount();
    }

    public PortDetails getPortDetailsById(int portId) {
        return anchorDataRepository.getPortDetailsById(portId);
    }

    public int getVesselDetailsCount() {
        return vesselRepository.getVesselDetailsCount();
    }
}
