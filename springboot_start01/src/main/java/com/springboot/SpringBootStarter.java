package com.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 李嘉图
 * @date 2020/5/18  18:03
 */
@SpringBootApplication
@MapperScan("com.springboot.mapper")//扫描mapper接口
public class SpringBootStarter {
    public static void main(String[] args) {
        //启动类
        SpringApplication.run(SpringBootStarter.class);
    }
}
