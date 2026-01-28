package com.security.service.controller;

import com.security.service.dto.ServiceRequestDTO;
import com.security.service.dto.ServiceResponseDTO;
import com.security.service.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // ==================== READ ====================

    /**
     * GET /api/services
     * Obtener todos los servicios
     */
    @GetMapping
    public ResponseEntity<List<ServiceResponseDTO>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    /**
     * GET /api/services/{id}
     * Obtener un servicio por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> getServiceById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }

    /**
     * GET /api/services/status/{status}
     * Obtener servicios por estado
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ServiceResponseDTO>> getServicesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(serviceService.getServicesByStatus(status));
    }

    /**
     * GET /api/services/alcaldia/{alcaldiaId}
     * Obtener servicios por alcaldía
     */
    @GetMapping("/alcaldia/{alcaldiaId}")
    public ResponseEntity<List<ServiceResponseDTO>> getServicesByAlcaldia(@PathVariable Integer alcaldiaId) {
        return ResponseEntity.ok(serviceService.getServicesByAlcaldia(alcaldiaId));
    }

    /**
     * GET /api/services/client/{clientId}
     * Obtener servicios por cliente
     */
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ServiceResponseDTO>> getServicesByClient(@PathVariable Integer clientId) {
        return ResponseEntity.ok(serviceService.getServicesByClient(clientId));
    }

    /**
     * GET /api/services/health
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Service API is running");
    }

    // ==================== CREATE ====================

    /**
     * POST /api/services
     * Crear un nuevo servicio
     */
    @PostMapping
    public ResponseEntity<ServiceResponseDTO> createService(@Valid @RequestBody ServiceRequestDTO request) {
        ServiceResponseDTO created = serviceService.createService(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // ==================== UPDATE ====================

    /**
     * PUT /api/services/{id}
     * Actualizar un servicio completo
     */
    @PutMapping("/{id}")
    public ResponseEntity<ServiceResponseDTO> updateService(
            @PathVariable Long id,
            @Valid @RequestBody ServiceRequestDTO request) {
        ServiceResponseDTO updated = serviceService.updateService(id, request);
        return ResponseEntity.ok(updated);
    }

    /**
     * PATCH /api/services/{id}/status
     * Actualizar solo el estado de un servicio
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<ServiceResponseDTO> updateServiceStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        ServiceResponseDTO updated = serviceService.updateServiceStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    /**
     * PUT /api/services/{id}/complete
     * Marcar un servicio como completado
     */
    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeService(@PathVariable Long id) {
        serviceService.completeService(id);
        return ResponseEntity.noContent().build();
    }

    // ==================== DELETE ====================

    /**
     * DELETE /api/services/{id}
     * Eliminar un servicio
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}