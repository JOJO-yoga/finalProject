package com.example.finalproject.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.finalproject.dao.userDao;
import com.example.finalproject.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
@Service
@Component
public class userServiceIml implements userService {
    @Autowired
    private userDao userdao;


    @Override
    public user findUserById(int id) {
        return userdao.findUserById(id);
    }

    @Override
    public user findUserByEmail(String email) {
        return userdao.findUserByEmail(email);
    }

    @Override
    public List<user> findAll() {
        return userdao.findAll();
    }

    @Override
    public user save(user userInfo) {
        return userdao.save(userInfo);
    }

    @Override
    public Page<user> findUserList(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"id");
        return userdao.findAll(pageable);
    }

    @Override
    public user findUserByName(String name) {
        return userdao.findUserByName(name);
    }
}
