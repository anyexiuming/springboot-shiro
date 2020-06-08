package com.springboot.service;

import com.springboot.mapper.AccountMapper;
import com.springboot.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李嘉图
 * @date 2020/5/21  22:51
 */
@Service
@Transactional//在类声明事务
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * 通过ID查找账户
     * @param id
     * @return
     */
    @Transactional//只要在对应的方法上加事务，就生效
    public Account QueryById(Integer id){
        return accountMapper.selectByPrimaryKey(id);
    }

}
