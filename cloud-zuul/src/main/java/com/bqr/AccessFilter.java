package com.bqr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bqr.exception.BusinessException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter
{
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
    
    @Override
    public String filterType()
    {
        return "post";
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
//        try
//        {
            if (accessToken == null)
            {
                log.warn("access token is empty");
                // ctx.setSendZuulResponse(false);
                // ctx.setResponseStatusCode(401);
                doSomething();
            }
//        }
//        catch (Exception e)
//        {
//            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ctx.set("error.exception", e);
//        }
        
        log.info("access token ok");
        return null;
    }
    
    private void doSomething()
    {
         throw new BusinessException(100010, "用户鉴权失败");
    }
}