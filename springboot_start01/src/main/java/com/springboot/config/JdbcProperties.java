package com.springboot.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 李嘉图
 * @date 2020/5/18  19:57
 */


//@ConfigurationProperties(prefix = "jdbc")
//前缀jdbc.driver=com.mysql.jdbc.Driver

//@Data //语法糖，不用写get，set
public class JdbcProperties {
    String driver;
    String url;
    String username;
    String password;

    //或者使用get，set


}
