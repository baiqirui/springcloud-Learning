package com.bqr.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service2",  fallback = ComputeClientHystrix2.class)
public interface ComputeClient2
{
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
    
    @RequestMapping(method = RequestMethod.GET, value = "/getB")
    Integer getB(@RequestParam(value = "b") Integer b, @RequestHeader("sessionId") String sessionId);
}