package com.security.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicesManagementApplication.class, args);
        System.out.println("\n========================================");
        System.out.println("  Security Services API iniciada");
        System.out.println("  URL: http://localhost:8080");
        System.out.println("  Health: http://localhost:8080/api/services/health");
        System.out.println("========================================\n");
    }
}