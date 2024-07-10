package com.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKey {

    @Value("${api-key}")
    private String podsApiKey;

    public String getApiKey() {
        return  this.podsApiKey;
    }
}
