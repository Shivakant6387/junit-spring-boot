package com.example.employeeservices.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//    @Bean
//   public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
    @Value("${addressservice.base.url}")
    private String addressBaseUrl;
    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl( addressBaseUrl).build();
    }
}
