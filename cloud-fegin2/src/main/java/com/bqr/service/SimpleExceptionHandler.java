package com.bqr.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * 一般异常拦截封装。
 *
 * @author: yidi
 */
@RestControllerAdvice
public class SimpleExceptionHandler extends ExceptionHandlerExceptionResolver {
    private static final int STATUS_ERROR = 400;

    private static final int STATUS_UNAUTHORIZED = 401;

    private static final int STATUS_SERVERERROR = 500;

    private static Logger logger = Logger.getLogger(SimpleExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public Object processException(HttpServletRequest request,
                                   HttpServletResponse response, Exception e) {

        logger.error(e);

        if ((e instanceof HttpRequestMethodNotSupportedException)
                && HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setStatus(200);
            return new ErrorResponse();
        }

        //客户端错误
        Integer code = 0;
        String message;
        int status = STATUS_ERROR;
        if (e instanceof IOException)  //IO 错误
        {
            message = "IO 错误。";
            logger.error("IOException:" + request.getRequestURI());
        } else if (e instanceof HttpMediaTypeException) {
            message = "转换错误。";
            logger.error("HttpMediaTypeException:" + request.getRequestURI());
        }
        if (e instanceof IOException)  //IO 错误
        {
            message = "IO 错误。";
            logger.error("IOException:" + request.getRequestURI());
        }
        else if (e instanceof HttpMediaTypeException)
        {
            message = "转换错误。";
            logger.error("HttpMediaTypeException:" + request.getRequestURI());
        }
        else if ((e instanceof BusinessException)
                || (e instanceof ServletRequestBindingException)
                || (e instanceof HttpRequestMethodNotSupportedException))
        {


            message = e.getMessage();
            int start = message.indexOf('[');
            if (start != -1)
            {
                int end = message.indexOf(']',start + 1);
                if (end != -1)
                {
//                    code = IntegerUtil.parse(message.substring(start + 1,end),new BooleanReference());
                    if (0 != code) {
                        message = message.substring(end + 1);
                    }
                }
            }

            {
                logger.error("Other Exception:" + request.getRequestURI());
                logger.error(null,e);
            }
        }
        //服务器端错误
        else {
            status = STATUS_SERVERERROR;

            Throwable cause = e;
            while (null != cause.getCause()) {
                cause = cause.getCause();
            }

            //2.5 modify by yidi
            //message = cause.getMessage();
            message = "系统好像出错了！等下再试试吧~";

        }

        response.setStatus(status);
        return new ErrorResponse(code, message);
    }

    /**
     * MissingServletRequestParameterException
     * @auth lvjj
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ErrorResponse processMissingServletRequestParameterException(HttpServletRequest request,
                                   HttpServletResponse response, MissingServletRequestParameterException e) {
        logger.error(e);

        response.setStatus(HttpStatus.BAD_REQUEST.value());

        String msg = "必须输入的 "+e.getParameterType()+" 类型参数 "+ e.getParameterName() +" 为空" ;

        return new ErrorResponse(0, msg);
    }
}
