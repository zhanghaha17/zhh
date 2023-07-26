package com.example.zhh.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfig {


/*    @Bean(name = "cxfServlet")  // 注入servlet bean name不能dispatcherServlet ,否则会覆盖dispatcherServlet
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public MyService codeService() {
        return new MyServiceImpl();
    }


    @Bean
    public Endpoint endpoint() {
        // 参数二，是SEI实现类对象
        org.apache.cxf.jaxws.EndpointImpl endpoint = new org.apache.cxf.jaxws.EndpointImpl(this.springBus(),this.codeService());
        // 发布服务
        endpoint.publish("/userService");
        return endpoint;
    }*/


/*    @Bean
    public Endpoint getEndpoint() {
        //Endpoint publish = EndpointImpl.publish("http://localhost:8082/show",new MyServiceImpl());
        Endpoint.publish("http://localhost:8082/show",new MyServiceImpl());
        return null;
    }*/
}
