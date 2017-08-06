package com.bqr;

import java.io.Serializable;

public class MealTimeResponse implements Serializable
{
    private static final long serialVersionUID = -5342249442797164588L;

    private int errorCode;
    
    private String errorMssage;

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMssage()
    {
        return errorMssage;
    }

    public void setErrorMssage(String errorMssage)
    {
        this.errorMssage = errorMssage;
    }
}
