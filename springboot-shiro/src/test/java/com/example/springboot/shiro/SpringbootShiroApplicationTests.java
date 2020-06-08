package com.example.springboot.shiro;

import com.example.springboot.shiro.entity.User;
import com.example.springboot.shiro.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShiroApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Test
     public void   find(){
        User admin = userService.findByName("admin");
        //System.out.println(admin);
    }

}
