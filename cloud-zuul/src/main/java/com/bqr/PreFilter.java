package com.bqr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bqr.exception.BusinessException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter
{
    private static Logger log = LoggerFactory.getLogger(PreFilter.class);
    
    @Override
    public String filterType()
    {
        return "pre";
    }
    
    @Override
    public int filterOrder()
    {
        return 10;
    }
    
    @Override
    public boolean shouldFilter()
    {
        return true;
    }
    
    @Override
    public Object run()
    {
        System.out.println("PreFilter aaaaaaaaaaaaaaaaaaaaaaaaa");
        return null;
    }
    
}