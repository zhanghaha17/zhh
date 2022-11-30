package com.example.zhh.controller;

import com.example.zhh.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;


    @GetMapping("/showUser")
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("href");
        return modelAndView;
    }

    @GetMapping("/queryAllUser")
    public Map<String,Object> queryAllUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userMapper.queryUserList());
        map.put("code",0);
        map.put("count",userMapper.queryUserList().size());
        map.put("msg",userMapper.queryUserList()!=null?"成功":"失败");
        return map;
    }

    @GetMapping("/showFile")
    public void downLoadFile(HttpServletRequest request,HttpServletResponse response) throws IOException {

        // 文件地址的全路径
        String httpUrl = "http://127.0.0.1:8087/xfpzh/service/rcwh/download/288/U0000001";
        ServletOutputStream out = null;
        try {
            // 与服务器建立连接
            URL url = new URL(httpUrl);
            URLConnection conn = url.openConnection();
            InputStream inputStream = conn.getInputStream();
            try {
                //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
                response.setContentType("multipart/form-data");
            } catch (Exception e){
                e.printStackTrace();
            }
            out = response.getOutputStream();
            // 读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
