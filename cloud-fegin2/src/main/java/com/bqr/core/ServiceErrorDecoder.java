package com.bqr.core;

import java.io.IOException;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

public class ServiceErrorDecoder implements ErrorDecoder
{
    final Decoder decoder;
    
    final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();
    
    public ServiceErrorDecoder(Decoder decoder)
    {
        this.decoder = decoder;
    }
    
    @Override
    public Exception decode(String methodKey, Response response)
    {
        try
        {
            return (Exception)decoder.decode(response, RuntimeException.class);
        }
        catch (IOException fallbackToDefault)
        {
            return defaultDecoder.decode(methodKey, response);
        }
    }
}
