package com.bqr.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 断路器
 * 
 * @author mealkey
 * @version [版本号, 2017年1月20日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class ComputeClientHystrix2 implements ComputeClient2
{
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b)
    {
        return -9999;
    }

    @Override
    public Integer getB(Integer b, String sessionId)
    {
        return 0;
    }
}