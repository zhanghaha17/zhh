package com.example.zhh.config;

import com.example.zhh.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//注册过滤器
@Configuration
public class WebFilterConfig {

    @Autowired
    private MyFilter myFilter;
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        return filterRegistrationBean;
    }
}
