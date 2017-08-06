package com.bqr.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqr.domain.User;
import com.google.common.collect.Maps;

@RestController
public class HelloController
{
    
    private static Map<String, User> map = Maps.newConcurrentMap();
    static
    {
        User c1 = new User("张三2", 1);
        User c2 = new User("李四2", 2);
        User c3 = new User("王五2", 3);
        map.put("1", c1);
        map.put("2", c2);
        map.put("3", c3);
    }
    
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }
    
    @RequestMapping("/hello")
    public String hello()
    {
        return "firsthello";
    }
    
    @RequestMapping("/legacy/hello")
    public String legacy()
    {
        return "legacy hello";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User add(@RequestBody User user, HttpServletRequest request)
    {
        System.out.println("request.getHeader(\"SESSIONID\") === " + request.getHeader("SESSIONID"));
        System.out.println("request.getHeader(\"Authorization\") === " + request.getHeader("Authorization"));
        
       map.put(user.getId().toString(), user);
       return user;
    }
    
    @RequestMapping(value = "/get/{owner}", method = RequestMethod.GET)
    public User get(@PathVariable String owner, HttpServletRequest request)
    {
        System.out.println("request.getHeader(\"SESSIONID\") === " + request.getHeader("SESSIONID"));
        System.out.println("request.getHeader(\"Authorization\") === " + request.getHeader("Authorization"));
        User user = map.get(owner);
        if (map.get(owner) == null)
        {
            throw new RuntimeException("未找到资源");
        }
        else
        {
            return user;
        }
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list(HttpServletRequest request)
    {
        System.out.println("request.getHeader(\"SESSIONID\") === " + request.getHeader("SESSIONID"));
        System.out.println("request.getHeader(\"Authorization\") === " + request.getHeader("Authorization"));
        List<User> users = new ArrayList<User>();
        for (Map.Entry<String, User> entry : map.entrySet())
        {
            users.add(entry.getValue());
        }
        return users;
    }
}
