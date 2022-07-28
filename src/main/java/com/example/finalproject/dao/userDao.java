package com.example.finalproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.finalproject.entity.user;
import java.util.List;

@Component
public interface userDao extends JpaRepository<user, String>{
    public user findUserById(int id);
    public user findUserByEmail(String email);
    public List<user> findAll();
    public user save(user userInfo);

    public user findUserByName(String name);

}
