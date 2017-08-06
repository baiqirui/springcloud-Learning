package com.bqr;

import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestAttributes;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;


/**
 * 这里用了@SpringCloudApplication注解，之前没有提过，通过源码我们看到，
 * 它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，主要目的还是简化配置。
 * 
 * @author mealkey
 * @version [版本号, 2017年1月20日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
//@EnableCircuitBreaker
@EnableZuulProxy
//@SpringCloudApplication
@SpringBootApplication
public class ZuulApplication
{
    public static void main(String[] args)
    {
        try
        {
            FilterLoader.getInstance().setCompiler(new GroovyCompiler());
            FilterFileManager.setFilenameFilter(new GroovyFileFilter());
            FilterFileManager.init(10,"D:\\test\\1");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
    
  @Bean
  public PreFilter preFilter()
  {
      return new PreFilter();
  }
    
//    @Bean
//    public AccessFilter accessFilter()
//    {
//        return new AccessFilter();
//    }
//    
//    @Bean
//  public ErrorFilter errorFilter()
//  {
//      return new ErrorFilter();
//  }
    
    
    
    
    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes (RequestAttributes requestAttributes,
            boolean includeStackTrace){
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
//                errorAttributes.remove("error");
//                errorAttributes.remove("exception");
//                errorAttributes.remove("timesta");
//                errorAttributes.clear();
                System.out.println( errorAttributes);
//                Map<String, Object> errorAttributes = new LinkedHashMap<String, Object>();
//                errorAttributes.put("code",requestAttributes.getAttribute("code", RequestAttributes.SCOPE_REQUEST));
//                errorAttributes.put("error",requestAttributes.getAttribute("error", RequestAttributes.SCOPE_REQUEST));
                return errorAttributes;
            }
        };
    }
//    
}