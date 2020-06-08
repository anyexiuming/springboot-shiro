package com.example.springboot.shiro.config;

import com.example.springboot.shiro.entity.User;
import com.example.springboot.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 李嘉图
 * @date 2020/6/6 14:41
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        User loginUser = (User) subject.getPrincipal();
        //查询当前用户的授权
        User dbUser = userService.findById(loginUser.getId());
        info.addStringPermission(dbUser.getPerms());

        return info;
    }

    /**'
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        //登录校验
        //String username="admin";
        //String password="123";

        //获取表单数据
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

        //查询数据库的用户
        User dbUser = userService.findByName(token.getUsername());

        //对比
        if(dbUser==null){
            //用户名不存在
            return null;
        }
        //判断密码
        return new SimpleAuthenticationInfo(dbUser,dbUser.getPassword(),"");
    }
}
