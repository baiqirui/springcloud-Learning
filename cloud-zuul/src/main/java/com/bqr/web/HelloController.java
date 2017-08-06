package com.bqr.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    
    @RequestMapping(value = "/second/list", method = RequestMethod.GET)
    public  String list(HttpServletRequest request)
    {
        return "zuul second userList";
    }
}
