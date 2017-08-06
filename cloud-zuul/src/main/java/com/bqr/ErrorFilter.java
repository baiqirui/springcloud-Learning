package com.bqr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ReflectionUtils;

import com.bqr.exception.BusinessException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ErrorFilter extends ZuulFilter
{
    Logger log = LoggerFactory.getLogger(ErrorFilter.class);
    
    protected static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";
    
    @Value("${error.path:/error}")
    private String errorPath;
    
    @Override
    public String filterType()
    {
        return "error";
    }
    
    @Override
    public int filterOrder()
    {
        return 0;
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
        try
        {
//            String a = null;
//            a.length();
         
            Throwable throwable = ctx.getThrowable();
            
            log.error("this is a ErrorFilter : {}", throwable.getCause().getMessage());
            
            if (throwable.getCause() instanceof BusinessException)
            {
                BusinessException e = (BusinessException)throwable.getCause();
                request.setAttribute("code", e.getErrorCode());
                request.setAttribute("error", e.getMessage());
            }
            else
            {
                request.setAttribute("code", 999999);
                request.setAttribute("error", throwable.getCause().getMessage());
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPath);
            if (dispatcher != null)
            {
                ctx.set(SEND_ERROR_FILTER_RAN, true);
                if (!ctx.getResponse().isCommitted())
                {
                    dispatcher.forward(request, ctx.getResponse());
                }
            }
            // ctx.set("error.status_code", request.getAttribute("errorCode"));
            
        }
        catch (Exception e)
        {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        
        return null;
        
    }
}