package com.bqr.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqr.core.ForwardedForInterceptor;
import com.bqr.core.ServiceErrorDecoder;
import com.bqr.domain.User;
import com.bqr.service.ComputeClient;
import com.bqr.service.ComputeClient2;
import com.bqr.service.ComputeClient3;
import com.bqr.service.IService;

import feign.Client;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Import(FeignClientsConfiguration.class)
@RestController
public class HelloFeignController
{
    IService service = Feign.builder()
        .encoder(new GsonEncoder())
        .decoder(new GsonDecoder())
        .errorDecoder(new ServiceErrorDecoder(new GsonDecoder()))
        .logger(new Logger.ErrorLogger())
        .logLevel(Logger.Level.BASIC)
        .requestInterceptor(new ForwardedForInterceptor())
        .requestInterceptor(new BasicAuthRequestInterceptor("baiqirui", "123456"))
        .target(IService.class, "http://localhost:2226");
    
    @Autowired
    ComputeClient computeClient;
    
    @Autowired
    ComputeClient2 computeClient2;
    
    ComputeClient3 computeClient3 ;
    
    
    @Autowired
    public void initClient3(ResponseEntityDecoder decoder, SpringEncoder encoder, Client client)
    {
        this.computeClient3 = Feign.builder()
            .client(client)
            .encoder(encoder)
            .decoder(decoder)
            .contract(new SpringMvcContract())
            .requestInterceptor(new BasicAuthRequestInterceptor("admin", "admin"))
            .target(ComputeClient3.class, "http://compute-service3");
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User get(@RequestBody User user, HttpServletRequest request)
    {
        // System.out.println(user);
        return service.add(user);
    }
    
    @RequestMapping(value = "/get/{owner}", method = RequestMethod.GET)
    public User get(@PathVariable String owner)
    {
        User user = service.get(owner);
        if (user != null)
        {
            System.out.println(user.getId() + "(" + user.getName() + ")");
        }
        return user;
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> get()
    {
        List<User> users = service.list();
        if (users != null && users.size() > 0)
        {
            for (User user : users)
            {
                System.out.println(user.getId() + "(" + user.getName() + ")");
            }
        }
        return users;
    }
    
    @RequestMapping(value = "/get1/{id}", method = RequestMethod.GET)
    public User get1(@PathVariable String id)
    {
        // String a = null;
        // a.length();
        User user = computeClient.get(id);
        if (user != null)
        {
            System.out.println(user.getId() + "(" + user.getName() + ")");
        }
        return user;
    }
    
    @RequestMapping(value = "/get2/{id}", method = RequestMethod.GET)
    public User get2(@PathVariable String id)
    {
        // String a = null;
        // a.length();
        User user = computeClient2.get(id);
        if (user != null)
        {
            System.out.println(user.getId() + "(" + user.getName() + ")");
        }
        return user;
    }
    
    @RequestMapping(value = "/get3/{id}", method = RequestMethod.GET)
    public User get3(@PathVariable String id)
    {
        // String a = null;
        // a.length();
        User user = computeClient3.get(id);
        if (user != null)
        {
            System.out.println(user.getId() + "(" + user.getName() + ")");
        }
        return user;
    }
    
}
