package com.example.zhh.config;

import com.example.zhh.inteceptor.MyInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    /*
     *addResourceHandler:访问映射路径
     *addResourceLocations:资源绝对路径
     */
    @Autowired
    private MyInteceptor myInteceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/product/**").addResourceLocations("file:D:/nngg/ffmpeg-2023-02-22-git-d5cc7acff1-full_build/bin/");
//        registry.addResourceHandler("/image/**").addResourceLocations("file:///C:/Users/user/Pictures/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/").addResourceLocations("classpath:/templates/");
    }

//    注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(myInteceptor);
    }

}
