package com.example.springboot.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李嘉图
 * @date 2020/6/6 15:00
 */
@Controller
@RequestMapping("/user")
public class UserController {



    /**
     * 跳转用户更新页面
     * @return
     */
    @RequestMapping("/updatePage")
    public String updatePage(){
        return "user/user-update";
    }


    /**
     * 跳转用户添加页面
     * @return
     */
    @RequestMapping("/addPage")
    public String addPage(){
        return "user/user-add";
    }


    /**
     * 跳转用户列表页面
     * @return
     */
    @RequestMapping("/listPage")
    public String listPage(){
        return "user/user-list";
    }








}
