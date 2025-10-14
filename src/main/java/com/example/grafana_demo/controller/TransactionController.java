package com.example.grafana_demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    JdbcTemplate jdbc;


    public String ping() {
        return "OK";
    }


    @GetMapping("/fail")
    public String fail() {
        throw new RuntimeException("Test error");
    }
    @GetMapping("/dbtest")
    public List<Map<String,Object>> dbtest() {
        return jdbc.queryForList("SELECT * from act_ge_bytearray");
    }
}