package com.bqr.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class TestController
{
    @Value("${from}")
    private String from;
    
    @Value("${com.name}")
    private String name;
    
    @RequestMapping("/from")
    public String from()
    {
        return this.from;
    }
    
    @RequestMapping("/name")
    public String name()
    {
        return this.name;
    }
}