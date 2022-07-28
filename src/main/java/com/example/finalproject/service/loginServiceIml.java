package com.example.finalproject.service;

import com.example.finalproject.dao.userDao;
import com.example.finalproject.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张子行
 * @class UserDetailsService
 */
@Service("userDetailsService")
class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private userDao userDao;

    /**
     * @param
     * @method 登录逻辑
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //调用usersMapper方法，根据用户名查询数据库
        user user = userDao.findUserByName(name);

        //判断
        if (user == null) {//数据库没有用户名，认证失败
            throw new UsernameNotFoundException("用户名不存在！");
        }

        //角色要加前缀ROLE_ ，权限直接没啥要求
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        //从查询数据库返回users对象，得到用户名和密码，返回
        return new org.springframework.security.core.userdetails.User(user.getName(),
                new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
