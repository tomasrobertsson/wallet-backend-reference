package com.example.demo.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("wallet")
public record DemoApplicationConfig() {
    // record if possible
}
