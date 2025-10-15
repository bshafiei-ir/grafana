package com.example.grafana_demo.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomMetricsInitializer {

    private final MeterRegistry meterRegistry;
    private Counter orderCounter;

    public CustomMetricsInitializer(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        orderCounter = Counter.builder("custom_order_count")
                .description("bahman shafiei: registered orders count")
                .register(meterRegistry);
        
        orderCounter.increment();
    }

    public void incrementOrderCount() {
        orderCounter.increment();
    }
}

