package com.security.service.service.impl;

import com.security.service.dto.ServiceRequestDTO;
import com.security.service.dto.ServiceResponseDTO;
import com.security.service.repository.ServiceRepository;
import com.security.service.service.ServiceService;
import jakarta.persistence.EntityNotFoundException;
import com.security.service.model.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // ==================== READ ====================
    
    @Override
    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> getAllServices() {
        return serviceRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ServiceResponseDTO getServiceById(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado con ID: " + id));
        return toResponse(service);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> getServicesByStatus(String status) {
        return serviceRepository.findAll()
                .stream()
                .filter(s -> s.getStatus() != null && s.getStatus().equalsIgnoreCase(status))
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> getServicesByAlcaldia(Integer alcaldiaId) {
        return serviceRepository.findAll()
                .stream()
                .filter(s -> s.getAlcaldiaId() != null && s.getAlcaldiaId().equals(alcaldiaId))
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServiceResponseDTO> getServicesByClient(Integer clientId) {
        return serviceRepository.findAll()
                .stream()
                .filter(s -> s.getClientId() != null && s.getClientId().equals(clientId))
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // ==================== CREATE ====================
    
    @Override
    @Transactional
    public ServiceResponseDTO createService(ServiceRequestDTO request) {
        Service service = new Service();
        mapRequestToEntity(request, service);
        Service savedService = serviceRepository.save(service);
        return toResponse(savedService);
    }

    // ==================== UPDATE ====================
    
    @Override
    @Transactional
    public ServiceResponseDTO updateService(Long id, ServiceRequestDTO request) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado con ID: " + id));
        
        mapRequestToEntity(request, service);
        Service updatedService = serviceRepository.save(service);
        return toResponse(updatedService);
    }

    @Override
    @Transactional
    public ServiceResponseDTO updateServiceStatus(Long id, String status) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado con ID: " + id));

        service.setStatus(status);
        Service updatedService = serviceRepository.save(service);
        return toResponse(updatedService);
    }

    @Override
    @Transactional
    public void completeService(Long id) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Servicio no encontrado con ID: " + id));

        service.setStatus("COMPLETADO");
        serviceRepository.save(service);
    }

    // ==================== DELETE ====================
    
    @Override
    @Transactional
    public void deleteService(Long id) {
        if (!serviceRepository.existsById(id)) {
            throw new EntityNotFoundException("Servicio no encontrado con ID: " + id);
        }
        serviceRepository.deleteById(id);
    }

    // ==================== MAPPERS ====================
    
    private void mapRequestToEntity(ServiceRequestDTO request, Service service) {
        service.setClientId(request.getClientId());
        service.setAlcaldiaId(request.getAlcaldiaId());
        service.setServiceTypeId(request.getServiceTypeId());
        service.setServiceCategoryId(request.getServiceCategoryId());
        service.setPriorityId(request.getPriorityId());
        service.setStatus(request.getStatus());
        service.setScheduledDate(request.getScheduledDate());
    }
    
    private ServiceResponseDTO toResponse(Service service) {
        ServiceResponseDTO dto = new ServiceResponseDTO();
        dto.setServiceId(service.getServiceId());
        dto.setClientId(service.getClientId());
        dto.setAlcaldiaId(service.getAlcaldiaId());
        dto.setServiceTypeId(service.getServiceTypeId());
        dto.setServiceCategoryId(service.getServiceCategoryId());
        dto.setPriorityId(service.getPriorityId());
        dto.setStatus(service.getStatus());
        dto.setScheduledDate(service.getScheduledDate());
        return dto;
    }
}