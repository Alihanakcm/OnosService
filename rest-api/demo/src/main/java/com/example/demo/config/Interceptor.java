package com.example.demo.config;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Interceptor {
    @Bean
    public RequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("onos", "rocks");
    }
    }

