package com.security.service.service;

import com.security.service.dto.ServiceRequestDTO;
import com.security.service.dto.ServiceResponseDTO;

import java.util.List;

public interface ServiceService {

    // READ operations
    List<ServiceResponseDTO> getAllServices();

    ServiceResponseDTO getServiceById(Long id);

    List<ServiceResponseDTO> getServicesByStatus(String status);

    List<ServiceResponseDTO> getServicesByAlcaldia(Integer alcaldiaId);

    List<ServiceResponseDTO> getServicesByClient(Integer clientId);

    // CREATE operation
    ServiceResponseDTO createService(ServiceRequestDTO request);

    // UPDATE operations
    ServiceResponseDTO updateService(Long id, ServiceRequestDTO request);
    
    ServiceResponseDTO updateServiceStatus(Long id, String status);

    void completeService(Long id);

    // DELETE operation
    void deleteService(Long id);
}