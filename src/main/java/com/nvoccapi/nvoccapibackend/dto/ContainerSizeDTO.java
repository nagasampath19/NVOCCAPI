package com.nvoccapi.nvoccapibackend.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ContainerSizeDTO {
    private Integer containersize_id;
    private String containersize_type;
    private String containersize_desc;
    private String containersize_code;

    public Integer getContainersize_id() {
        return containersize_id;
    }

    public void setContainersize_id(Integer containersize_id) {
        this.containersize_id = containersize_id;
    }

    @NotEmpty(message = "Container type must not be empty")
    @Size(max = 25, message = "Container type must not exceed 25 characters")
    public String getContainersize_type() {
        return containersize_type;
    }

    public void setContainersize_type(String containersize_type) {
        this.containersize_type = containersize_type;
    }

    public String getContainersize_desc() {
        return containersize_desc;
    }

    public void setContainersize_desc(String containersize_desc) {
        this.containersize_desc = containersize_desc;
    }

    public String getContainersize_code() {
        return containersize_code;
    }

    public void setContainersize_code(String containersize_code) {
        this.containersize_code = containersize_code;
    }
}
