package com.example.springboot.shiro.service;

import com.example.springboot.shiro.entity.User;

/**
 * @author 李嘉图
 * @date 2020/6/7 11:38
 */
public interface UserService {
     User findByName(String username);
     User findById(Integer id);
}
