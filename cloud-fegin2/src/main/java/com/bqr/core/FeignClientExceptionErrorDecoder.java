package com.bqr.core;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.bqr.service.BusinessException;
import com.bqr.service.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FeignClientExceptionErrorDecoder implements ErrorDecoder
{
    private final ErrorDecoder delegate = new ErrorDecoder.Default();
    
    @Override
    public Exception decode(String methodKey, Response response)
    {
        try
        {
            String message = Util.toString(response.body().asReader());
            int status = response.status();
            StringBuffer sb = new StringBuffer("feign调用service时发送错误，");
            sb.append( "http状态：").append(status).append("  错误信息：").append(message);
            log.error(sb.toString());
            if (status >= 400 && status <= 500)
            {
                if (StringUtils.isNotBlank(message))
                {
                    final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
                    ObjectMapper mapper = converter.getObjectMapper();
                    ErrorResponse errorResponse = mapper.readValue(message, ErrorResponse.class);
                    return new BusinessException(errorResponse.getCode(), errorResponse.getError());
                }
                else
                {
                    return new BusinessException(0, "系统未知异常！");
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return delegate.decode(methodKey, response);
    }
}