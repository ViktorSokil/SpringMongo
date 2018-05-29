package com.journaldev.spring.mongodb.configurtion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean(name = "rest")
    public RestOperations restTemplate() {
        return new RestTemplate();
    }
}
