package com.example.finalproject.service;
import com.example.finalproject.entity.user;
import org.springframework.data.domain.Page;

import java.util.List;
public interface userService {
    user findUserById(int id);
    user findUserByEmail(String email);
    List<user> findAll();
    user save(user userInfo);
    Page<user> findUserList(int pageNum, int pageSize);
    user findUserByName(String name);
}
