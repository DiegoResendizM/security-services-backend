package com.security.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "ServiceCategories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_category_id")
    private Integer serviceCategoryId;
    
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;
}