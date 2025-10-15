package com.example.grafana_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/metric")
public class MetricController {
    @Timed(value = "custom_api_timer", description = "bahman shafiei: test of api execution time")
    @GetMapping("/api/test")
    public String test() {
        return "ok";
    }
}
