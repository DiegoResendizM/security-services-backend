package com.security.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Alcaldias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alcaldia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alcaldia_id")
    private Integer alcaldiaId;
    
    @Column(name = "name", nullable = false, length = 200, unique = true)
    private String name;
}