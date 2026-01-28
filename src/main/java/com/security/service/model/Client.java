package com.security.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;
    
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    
    @Column(name = "contact_name", length = 150)
    private String contactName;
    
    @Column(name = "phone", length = 50)
    private String phone;
    
    @Column(name = "email", length = 200)
    private String email;
    
    @Column(name = "address", length = 500)
    private String address;
    
    @Column(name = "default_alcaldia_id")
    private Integer defaultAlcaldiaId;
}