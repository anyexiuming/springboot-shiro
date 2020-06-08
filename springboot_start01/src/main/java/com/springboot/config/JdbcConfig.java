package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author 李嘉图
 * @date 2020/5/18  19:29
 */
//@PropertySource("classpath:application.properties")
//@EnableConfigurationProperties(JdbcProperties.class)//把jdbc的配置类注入，方法一
//@Configuration
public class JdbcConfig {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource dataSource(){

        DataSource dataSource = new DruidDataSource();

        return dataSource;

    }



//    @Value("${jdbc.driver}")
//     String driver;
//    @Value("${jdbc.url}")
//     String url;
//    @Value("${jdbc.username}")
//     String username;
//    @Value("${jdbc.password}")
//     String password;
//
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }


//    @Bean
//    public DataSource dataSource(JdbcProperties prop){
//        DruidDataSource dataSource = new DruidDataSource();
//        //初始化数据源
//        dataSource.setDriverClassName(prop.driver);
//        dataSource.setUrl(prop.url);
//        dataSource.setUsername(prop.username);
//        dataSource.setPassword(prop.password);
//        return dataSource;
//
//    }

    /*
    @Autowired //把jdbc的配置类注入，方法二
    JdbcProperties jdbcProperties;


    //把jdbc的配置类注入，构造函数，方法三
    public JdbcConfig( JdbcProperties jdbcProperties) {
        this.jdbcProperties=jdbcProperties;
    }

     */



}
