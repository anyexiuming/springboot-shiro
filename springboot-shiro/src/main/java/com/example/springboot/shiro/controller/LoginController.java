package com.example.springboot.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李嘉图
 * @date 2020/6/6 15:48
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 跳转的登录页面
     * @return
     */
    @RequestMapping("/loginPage")
    public String login(){
        return "login/login";
    }


    /**
     * 用户登录
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(String username, String password, Model model){
        //shiro的认证操作
        Subject subject = SecurityUtils.getSubject();
        //封装永固数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            //没有异常抛出则登录成功
            subject.login(usernamePasswordToken);
            //跳转首页
            return "redirect:/index";
        }catch (UnknownAccountException e){
            //e.printStackTrace();
            //用户名不存在
            model.addAttribute("msg","用户名不存在");
            //返回登录页面
            return "login/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            //返回登录页面
            return "login/login";
        }
    }


    /**
     * 跳转权限不足页面
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "login/unAuth";
    }

}
