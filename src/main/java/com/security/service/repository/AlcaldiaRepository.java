package com.security.service.repository;

import com.security.service.model.Alcaldia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcaldiaRepository extends JpaRepository<Alcaldia, Integer> {
}
