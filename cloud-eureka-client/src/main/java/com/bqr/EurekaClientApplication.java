package com.bqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
    
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer()
//    {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory()
//        {
//            @Override
//            protected void postProcessContext(Context context)
//            {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//        return tomcat;
//    }
//    
//    @Bean
//    public Connector httpConnector()
//    {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8080);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }
}
