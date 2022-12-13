package com.example.zhh.controller;

import com.example.zhh.dao.QuestionDetailMapper;
import com.example.zhh.dao.UserMapper;
import com.example.zhh.dao.back.UserMapperBack;
import com.example.zhh.pojo.*;
import com.example.zhh.service.SysLogDao;
import com.example.zhh.service.impl.UserMongoImpl;
import com.example.zhh.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(value = "*")
public class UserController {

    @Resource(type = UserMapperBack.class)
    private UserMapperBack userMapperBack;
    @Resource(type = com.example.zhh.dao.UserMapper.class)
    private UserMapper userMapper;
    @Resource
    private SysLogDao sysLogDao;
    @Resource
    private QuestionDetailMapper questionDetailMapper;
    @Resource
    private UserMongoImpl userMongoImpl;
    @GetMapping("/showUser")
    public ModelAndView showUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("User");
        return modelAndView;
    }

    @GetMapping("/queryAllUser")
    public Map<String,Object> queryAllUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userMapper.queryUserList());
        map.put("dataBack",userMapperBack.queryUserList());
        map.put("code",0);
        map.put("count",userMapper.queryUserList().size());
        map.put("msg",userMapper.queryUserList()!=null?"成功":"失败");
        return map;
    }

    @GetMapping("/testMybatis")
    public void testMybatis(){
        QuestionDetailExample questionDetailExample = new QuestionDetailExample();
        QuestionDetailExample.Criteria criteria = questionDetailExample.createCriteria();
        criteria.andDifficultLevelEqualTo("easy");
        int i = questionDetailMapper.countByExample(questionDetailExample);
        System.out.println("问题详情:"+i);
    }

    @GetMapping("/saveSysLog")
    public void saveSysLog(){
        SysLog sysLog = new SysLog();
        sysLog.setCreateTime(new Date(System.currentTimeMillis()));
        sysLog.setIp("127.0.0.1");
        sysLog.setMethod("get");
        sysLog.setOperation("insert");
        sysLog.setParams("void");
        sysLog.setTime(0);
        sysLog.setUsername("zhh");
        sysLogDao.saveSysLog(sysLog);
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

    @GetMapping("/queryUserMongo")
    public List<UserMongo> queryUserMongo(){
        return userMongoImpl.getAllUser();
    }

    @PostMapping("/saveUserMongo")
    public void saveUserMongo(@RequestBody UserMongo userMongo){
        userMongoImpl.saveUser(userMongo);
    }


//    关于shiro

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(@RequestBody User user,HttpServletResponse response,HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        String username = user.getUsername();
        String password = user.getPassword();
        // 密码MD5加密
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new ResponseBo(200,"登录认证成功",token);
        } catch (UnknownAccountException e) {
            throw new UnknownAccountException("账户未知");
        } catch (IncorrectCredentialsException e) {
            throw new IncorrectCredentialsException("通行证不正确");
        } catch (LockedAccountException e) {
            throw new LockedAccountException("账户被锁定");
        } catch (AuthenticationException e) {
            throw new AuthenticationException("认证失败");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/user/index";
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addObject("username", user.getUsername());
        model.setViewName("index");
        return model;
    }
}
