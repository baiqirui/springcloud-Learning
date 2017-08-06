package com.bqr.service;

public class ErrorResponse
{
    /**
     * 错误编码（默认值0）
     */
    private Integer code;
    
    /**
     * 错误消息
     */
    private String error;
    
    public ErrorResponse()
    {
    }
    
    public ErrorResponse(Integer code, String error)
    {
        this.code = code;
        this.error = error;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }
}
