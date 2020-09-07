package com.ljf.sso.demo.ssoclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: liujianfu
 * @Date: 2020/09/04 20:13:49 
 * @Version: V1.0
 **/
@Controller
public class LoginController {
    /**
    * @author liujianfu
    * @description       
    * @date 2020/9/4 20:20
    * @param []        
    * @return java.lang.String
    */
    @RequestMapping("/index")
    public String index(Model model) {
       String msg="";
       System.out.println("controller......");
        model.addAttribute("msg",msg);
        return "login";
    }
    /**
    * @author liujianfu
    * @description
    * @date 2020/9/4 20:23
    * @param [username, password, request, session, response, model]
    * @return java.lang.String
    */
    @RequestMapping("/login")
    public String login(String userName, String passWord,
                        HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) throws Exception {
        System.out.println(userName + "," + passWord);
        System.out.println("进入了登录方法......");
        String path = request.getRequestURL().toString();
        System.out.println("path:" + path);
        String msg="";
        //登录成功
        if ((userName != null && "admin".equals(userName)) && (passWord != null && "123".equals(passWord))) {
            model.addAttribute("userName",userName);
            model.addAttribute("passWord",passWord);
            return "main";
        } else {
            System.out.println("用户名或密码错误！");
            msg="用户名或密码错误！";
            model.addAttribute("msg",msg);
            return "login";
        }

    }
    /**
    * @author liujianfu
    * @description       退出到登录页
    * @date 2020/9/7 8:58
    * @param [request, session, response, model]
    * @return java.lang.String
    */
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request, HttpSession session, HttpServletResponse response, Model model) throws Exception {
        System.out.println("进入退出方法!!!!");
        session.invalidate();
        //String redirectUrl = "http://192.168.110.195:8888/sso/api/index" ;
        return "login";
    }

}
