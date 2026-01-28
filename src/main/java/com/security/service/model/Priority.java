package com.security.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Priorities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Priority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "priority_id")
    private Byte priorityId;
    
    @Column(name = "name", nullable = false, length = 20, unique = true)
    private String name;
    
    @Column(name = "rank_index", nullable = false)
    private Byte rankIndex;
}