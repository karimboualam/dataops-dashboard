package com.dataops.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class CityController {

    @GetMapping("/api/cities")
    public List<Map<String, String>> getCities() {
        return List.of(
                Map.of("name", "Paris", "country", "France"),
                Map.of("name", "Madrid", "country", "Spain"),
                Map.of("name", "Rome", "country", "Italy")
        );
    }
}
