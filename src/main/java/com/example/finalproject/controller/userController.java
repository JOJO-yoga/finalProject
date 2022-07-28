package com.example.finalproject.controller;

import com.example.finalproject.entity.score;
import com.example.finalproject.entity.user;
import com.example.finalproject.service.userService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.finalproject.dao.userDao;

import java.util.List;

@Controller
@RequestMapping("user")
public class userController {
    @Autowired
    private userDao userdao;
    @Autowired
    private userService userService;
    @RequestMapping("register")
    public String addUser(
                          @RequestParam("name")String name,
                          @RequestParam("password")String password,
                          @RequestParam("age")int age,
                          @RequestParam("email")String email
    ){
        user user1=new user(name,password,age,email);
        userdao.save(user1);
        return "login";
    }

    @RequestMapping("login")
    public String login(
            @RequestParam("id")int id,
            @RequestParam("password")String password
    ){
        user user1=userdao.findUserById(id);
        return "login";
    }

}
