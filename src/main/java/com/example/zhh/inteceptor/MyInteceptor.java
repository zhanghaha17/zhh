package com.example.zhh.inteceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        System.out.println("处理拦截之前");
        System.out.println("类名："+((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println("方法名："+((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("start",System.currentTimeMillis());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("处理拦截");
        System.out.println("耗时："+(System.currentTimeMillis()-(Long) request.getAttribute("start")));
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("处理拦截之后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
