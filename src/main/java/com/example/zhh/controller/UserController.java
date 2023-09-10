package com.example.zhh.controller;

import com.example.zhh.annotation.Log;
import com.example.zhh.component.ApplicationValue;
import com.example.zhh.component.CustumeValue;
import com.example.zhh.dao.QuestionDetailMapper;
import com.example.zhh.dao.UserMapper;
import com.example.zhh.dao.back.UserMapperBack;
import com.example.zhh.pojo.*;
import com.example.zhh.service.SysLogDao;
import com.example.zhh.service.impl.UserMongoImpl;
import com.example.zhh.utils.MD5Utils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/user")
@CrossOrigin(value = "*")
@Validated
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
    @Resource
    private ApplicationValue applicationValue;
    @Autowired
    private CustumeValue custumeValue;

    @Autowired
    private ThreadPoolTaskExecutor executor;

//    @Autowired
//    private JavaMailSender jms;
//    @Value("${spring.mail.username}")
//    private String from;
    @GetMapping("/showUser")
    public ModelAndView showUser(){
        int value = custumeValue.getA();
        System.out.println("value"+value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("User");
        return modelAndView;
    }

    @GetMapping("/queryAllUser")
    @ResponseBody
    public Map<String,Object> queryAllUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("data",userMapper.queryUserList());
//        map.put("dataBack",userMapperBack.queryUserList());
        map.put("code",0);
        map.put("count",userMapper.queryUserList().size());
        map.put("msg",userMapper.queryUserList()!=null?"成功":"失败");
        return map;
    }

    @GetMapping(value = "/testMybatis")
    @ResponseBody
    public void testMybatis(int id){
//        QuestionDetailExample questionDetailExample = new QuestionDetailExample();
//        QuestionDetailExample.Criteria criteria = questionDetailExample.createCriteria();
//        criteria.andDifficultLevelEqualTo("easy");
//        int i = questionDetailMapper.countByExample(questionDetailExample);
//        System.out.println("问题详情:"+i);
        String [] str = new String[]{"111","222"};
        System.out.println("str"+str.toString());
        System.out.println("id"+id);
        QuestionDetail questionDetail = new QuestionDetail();
        questionDetail.setQuestionId(666);
        questionDetail.setDifficultLevel("hard");
//        questionDetail.setId(new Random().nextInt(100));
        int insert = questionDetailMapper.insert(questionDetail);
        System.out.println("主键是"+questionDetail.getId());


//        TimerThread timerThread = new TimerThread();
//        timerThread.start();
//        System.out.println("开始");
    }

    @PostMapping("/saveSysLog")
    @ResponseBody
    @Log(value = "saveSysLog")
    public SysLog saveSysLog(@RequestBody SysLog sysLog,HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("file");
        System.out.println(path);
//        SysLog sysLog = new SysLog();
//        sysLog.setCreateTime(new Date(System.currentTimeMillis()));
//        sysLog.setIp("127.0.0.1");
//        sysLog.setMethod("put");
//        sysLog.setOperation("update");
//        sysLog.setParams("object");
//        sysLog.setTime(0);
//        sysLog.setUsername("lfqlfq");
//        sysLogDao.saveSysLog(sysLog);
        System.out.println("111");
        return sysLog;

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
    @ResponseBody
    public List<UserMongo> queryUserMongo(){
        return userMongoImpl.getAllUser();
    }

    @PostMapping("/saveUserMongo")
    @ResponseBody
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
        Boolean rememberMe = user.getRememberMe()==null?false:true;
        // 密码MD5加密
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
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

    @RequiresPermissions("user:user")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        return "user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }


    @Log("执行方法一")
    @RequestMapping("/testAspect/{id}")
    @ResponseBody
    public void testAspect(@PathVariable String id){
        System.out.println(id);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable(value = "id") Integer id) {
        User user = new User();
        user.setId(id);
        user.setUsername("mrbird");
        user.setAge(25);
        return user;
    }




/*    @RequestMapping("sendSimpleEmail")
    @ResponseBody
    public String sendSimpleEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo("1755743868@qq.com"); // 接收地址
            message.setSubject("一封简单的邮件"); // 标题
            message.setText("使用Spring Boot发送简单邮件。"); // 内容
            jms.send(message);
            return "发送成功1";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }*/


    @GetMapping("/testAsync")
    @ResponseBody
    public void testAsync(){
        long l = System.currentTimeMillis();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                Future<Integer> integerFuture = sysLogDao.testAsync();
                try {
                    System.out.println(integerFuture.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        },10000);
//        Future<Integer> integerFuture = sysLogDao.testAsync();
//        System.out.println("异步方法返回值"+integerFuture);
        System.out.println("执行时间为"+(System.currentTimeMillis()-l));

    }


}
