package com.springboot.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "account")//通用mapper不知道数据库的表名，自己声明
public class Account {
    //主键
    @Id
    @KeySql(useGeneratedKeys = true)//主键自增长
    private Integer id;
    private String name;
    private Double money;
}
