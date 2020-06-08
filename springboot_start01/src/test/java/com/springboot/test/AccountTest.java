package com.springboot.test;

import com.springboot.SpringBootStarter;
import com.springboot.mapper.AccountMapper;
import com.springboot.pojo.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 李嘉图
 * @date 2020/5/21  20:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarter.class)
public class AccountTest {
    @Autowired
    private AccountMapper accountMapper;//这个报错可以忽略


    @Test
    public void testQuery(){
        Account account = accountMapper.selectByPrimaryKey(2);

        System.out.println("account"+account);
    }
}
