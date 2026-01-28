package com.security.service.dto;

import java.time.LocalDate;

public class ServiceResponseDTO {

    private Long serviceId;
    private Integer clientId;
    private Integer alcaldiaId;
    private Integer serviceTypeId;
    private Integer serviceCategoryId;
    private Integer priorityId;
    private String status;
    private LocalDate scheduledDate;

    // Getters and Setters
    
    public Long getServiceId() { 
        return serviceId; 
    }
    
    public void setServiceId(Long serviceId) { 
        this.serviceId = serviceId; 
    }

    public Integer getClientId() { 
        return clientId; 
    }
    
    public void setClientId(Integer clientId) { 
        this.clientId = clientId; 
    }

    public Integer getAlcaldiaId() { 
        return alcaldiaId; 
    }
    
    public void setAlcaldiaId(Integer alcaldiaId) { 
        this.alcaldiaId = alcaldiaId; 
    }

    public Integer getServiceTypeId() { 
        return serviceTypeId; 
    }
    
    public void setServiceTypeId(Integer serviceTypeId) { 
        this.serviceTypeId = serviceTypeId; 
    }

    public Integer getServiceCategoryId() { 
        return serviceCategoryId; 
    }
    
    public void setServiceCategoryId(Integer serviceCategoryId) { 
        this.serviceCategoryId = serviceCategoryId; 
    }

    public Integer getPriorityId() { 
        return priorityId; 
    }
    
    public void setPriorityId(Integer priorityId) { 
        this.priorityId = priorityId; 
    }

    public String getStatus() { 
        return status; 
    }
    
    public void setStatus(String status) { 
        this.status = status; 
    }

    public LocalDate getScheduledDate() { 
        return scheduledDate; 
    }
    
    public void setScheduledDate(LocalDate scheduledDate) { 
        this.scheduledDate = scheduledDate; 
    }
}