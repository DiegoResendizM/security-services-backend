package com.security.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "ServiceTypes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer serviceTypeId;
    
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;
}