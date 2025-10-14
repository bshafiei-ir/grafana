package com.example.grafana_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/load-test")
public class LoadTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/dbload")
    public String dbLoadTest() {
        for (int i = 0; i < 10000; i++) {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM act_ge_bytearray LIMIT 1");
        }
        return "Executed 100 queries!";
    }
}
