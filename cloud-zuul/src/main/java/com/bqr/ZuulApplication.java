package com.bqr;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 这里用了@SpringCloudApplication注解，之前没有提过，通过源码我们看到，
 * 它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，主要目的还是简化配置。
 * 
 * @author mealkey
 * @version [版本号, 2017年1月20日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication
{
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
    
    @Bean
    public AccessFilter accessFilter()
    {
        return new AccessFilter();
    }
    
}