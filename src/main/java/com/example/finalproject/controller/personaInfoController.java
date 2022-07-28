package com.example.finalproject.controller;

import com.example.finalproject.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("info")
public class personaInfoController {
    @Autowired
    private com.example.finalproject.dao.userDao userDao;
    @RequestMapping("display")
    public String update(Model model
    ){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo= userDao.findUserByName(userDetails.getUsername());
        model.addAttribute("info",userInfo);
        return "personalPage";
    }

    @RequestMapping("modify")
    public String modify(Model model,
                         @RequestParam("name")String name,
                         @RequestParam("password")String password,
                         @RequestParam("age")int age,
                         @RequestParam("email")String email,
                         @RequestParam("id")int id
    ){
        user user1=userDao.findUserById(id);
        user1.setAge(age);
        user1.setName(name);
        user1.setEmail(email);
        user1.setPassword(password);
        userDao.save(user1);
        return "redirect:/info/display";
    }
}
