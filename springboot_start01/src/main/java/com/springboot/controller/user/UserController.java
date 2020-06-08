package com.springboot.controller.user;

import com.springboot.pojo.Account;
import com.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.websocket.server.PathParam;

/**
 * @author 李嘉图
 * @date 2020/5/18  18:08
 */
//@Controller
@RestController
// 就是controller 和responseBody的结合，但不能返回到jsp和html页面了
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountService accountService;
    
    @RequestMapping("/account/{id}")//前端传递的id数据
    public Account findAccountById(@PathVariable(value = "id") Integer id){
        //PathVariable：从路径中获取数据，再注入字段
        //RequestParam ：是从请求里面获取参数
        return accountService.QueryById(id);
    }

    @RequestMapping("/testUser")
    @ResponseBody
    public  String testUser(){
        System.out.println("测试执行了");
        return "hello,springboot";
    }
}
