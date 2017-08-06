package com.bqr.service;

import com.netflix.hystrix.exception.HystrixBadRequestException;

public class BusinessException extends HystrixBadRequestException
{
    private static final long serialVersionUID = 1L;
    
    private int errorCode;
    
    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public BusinessException(int errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }
    
}
