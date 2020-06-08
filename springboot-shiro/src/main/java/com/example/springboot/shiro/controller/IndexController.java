package com.example.springboot.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 李嘉图
 * @date 2020/6/6 15:53
 */
@Controller
public class IndexController {

    /**
     * 启动跳转首页
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView();
        model.addObject("user","test");
        model.setViewName("index/index");
        return model;
    }
}
