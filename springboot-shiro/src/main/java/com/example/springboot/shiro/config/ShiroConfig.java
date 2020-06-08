package com.example.springboot.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 李嘉图
 * @date 2020/6/6 14:20
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     * @return
     */
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //关联defaultWebSecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /**
         *  添加过滤器，实现拦截
         *  anon:无需认证，也能访问资源
         *  authc:必须认证
         *  user：使用rememberMe功能，可以直接访问
         *  perms:必须授予资源权限才能访问
         *  role：必须授予角色才能访问
         */
        //创建容器，LinkedHashMap保证有序性
        Map<String,String> map=new LinkedHashMap<>(16);
        //创建过滤器,规定那些路径要拦截
        //登录页面放行
        map.put("/login/login","anon");
        map.put("/login/loginPage","anon");

        //授权拦截器
        //位置在拦截所有资源的上面
        map.put("/user/addPage","perms[user:addPage]");
        map.put("/user/updatePage","perms[user:updatePage]");

        //其他页面拦截
        map.put("/index","authc");
        map.put("/user/*","authc");


        //没有认证的路径，跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/login/loginPage");
        //没有授权的路径，跳转未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/unAuth");
        //该过滤器生效
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建安全管理器
     * DefaultWebSecurityManager
     * @return
     */
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }


    /**
     * 创建Realm
     * @return
     */
    @Bean("userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }


    /**
     * 配置shiro和thymeleaf的标签扩展
     */
    @Bean("shiroDialect")
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
