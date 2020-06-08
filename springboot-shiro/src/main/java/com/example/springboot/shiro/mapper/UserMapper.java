package com.example.springboot.shiro.mapper;

import com.example.springboot.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 李嘉图
 * @date 2020/6/7 11:34
 */
//@Mapper
public interface UserMapper {
    User findByName(String username);

    User findById(Integer id);
}
