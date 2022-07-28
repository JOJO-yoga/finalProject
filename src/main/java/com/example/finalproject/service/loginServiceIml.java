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


@Service("userDetailsService")
class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private userDao userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        user user = userDao.findUserByName(name);

        if (user == null) {
            throw new UsernameNotFoundException("User not exist！");
        }

        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        return new org.springframework.security.core.userdetails.User(user.getName(),
                new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
