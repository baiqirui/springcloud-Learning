package com.bqr.service;


import java.util.List;

import com.bqr.domain.User;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IService
{
    @RequestLine("GET /get/{owner}")
    User get (@Param("owner")String owner);
    
    @RequestLine("GET /list")
    List<User> list();

    @RequestLine("POST /add")
    @Headers("Content-Type: application/json")
    User add(User user);

}
