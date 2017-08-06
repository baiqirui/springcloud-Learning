package com.bqr.core;


import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class MyFeignInterceptor implements RequestInterceptor
{
    @Override
    public void apply(RequestTemplate template)
    {
        System.out.println("aaaaaaaaaa");
        if (null != template.body())
        {
            String body = new String(template.body());
            System.out.println(body);
        }
        template.header("SESSIONID", "123456");
//        template.header("X-Forwarded-For", "origin.host.com");
    }
}