package com.security.service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Services", schema = "dbo")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "alcaldia_id")
    private Integer alcaldiaId;

    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "service_category_id")
    private Integer serviceCategoryId;

    @Column(name = "priority_id")
    private Integer priorityId;

    @Column(name = "status")
    private String status;

    @Column(name = "scheduled_date")
    private LocalDate scheduledDate;

    // ===== GETTERS & SETTERS =====

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
