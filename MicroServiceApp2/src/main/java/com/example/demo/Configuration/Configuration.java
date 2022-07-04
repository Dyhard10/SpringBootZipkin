package com.example.demo.Configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler alwaysSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

}
