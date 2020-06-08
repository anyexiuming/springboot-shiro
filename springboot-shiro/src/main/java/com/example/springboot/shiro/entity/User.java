package com.example.springboot.shiro.entity;

import lombok.Data;

/**
 * @author 李嘉图
 * @date 2020/6/7 10:14
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String perms;
}
