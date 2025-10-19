package com.dataops.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestDbController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TestDbController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/test-db")
    public Map<String, Object> testDatabaseConnection() {
        try {
            // Exécute une requête simple pour vérifier la connexion
            Map<String, Object> result = jdbcTemplate.queryForMap("SELECT NOW() AS current_time");
            return Map.of(
                    "status", "✅ Connected to PostgreSQL Render!",
                    "time", result.get("current_time")
            );
        } catch (Exception e) {
            return Map.of(
                    "status", "❌ Database connection failed",
                    "error", e.getMessage()
            );
        }
    }
}
