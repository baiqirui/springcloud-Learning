package com.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FooConfiguration
{
    
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor()
    {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}