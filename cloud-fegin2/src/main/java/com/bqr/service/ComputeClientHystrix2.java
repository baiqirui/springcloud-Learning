package com.bqr.service;

import org.springframework.stereotype.Component;

import com.bqr.domain.User;

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
    public User add(User user)
    {
        return new User("failUser2", -2);
    }

    @Override
    public User get(String id)
    {
        return new User("failUser2", -2);
    }
}