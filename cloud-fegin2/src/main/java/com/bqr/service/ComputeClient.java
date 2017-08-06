package com.bqr.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqr.domain.User;
import com.core.FooConfiguration;

@FeignClient(value = "compute-service1",  fallback = ComputeClientHystrix.class, configuration = FooConfiguration.class)
public interface ComputeClient
{
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    User add(@RequestBody User user);
    
    @RequestMapping(method = RequestMethod.GET,  value = "/get/{id}")
    User get(@PathVariable(value = "id") String id);
}