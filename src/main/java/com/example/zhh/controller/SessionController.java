package com.example.zhh.controller;

import com.example.zhh.pojo.ResponseBo;
import com.example.zhh.pojo.UserOnline;
import com.example.zhh.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/online")
@Controller
public class SessionController {

    @Autowired
    private  SessionService sessionService;

    @RequestMapping("index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }


    @RequestMapping("forceLogout")
    @ResponseBody
    public ResponseBo forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return new ResponseBo(200,"111",null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.error("踢出用户失败");
        }
    }
}
