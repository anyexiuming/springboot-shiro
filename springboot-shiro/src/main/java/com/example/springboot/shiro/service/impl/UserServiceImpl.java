package com.example.springboot.shiro.service.impl;

import com.example.springboot.shiro.mapper.UserMapper;
import com.example.springboot.shiro.entity.User;
import com.example.springboot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李嘉图
 * @date 2020/6/7 11:39
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value="userMapper")
    private UserMapper userMapper;//忽略

    @Override
    public User findByName(String username) {
        User user = userMapper.findByName(username);

        System.out.println("数据库查询的对象"+user);

        return user;
    }

    @Override
    public User findById(Integer id) {

        return userMapper.findById(id);
    }
}
