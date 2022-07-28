package com.example.finalproject.controller;

import com.example.finalproject.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {

    @Autowired
    private userDao userdao;

    @RequestMapping(value={"/register"})
    public String test(){
        return "register";
    }

    @RequestMapping(value={"/login"})
    public String index(){
        return "login";
    }

    @RequestMapping(value={"/rankchoose"})
    public String rankchoose(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        return "rankchoose";
    }

    @RequestMapping(value={"/level"})
    public String level(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        return "level";
    }

    @RequestMapping(value={"/index"})
    public String index(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        return "index";
    }

    @RequestMapping(value={"/question"})
    public String question(Model model){
        return "questions";
    }

    @RequestMapping(value={"/game"})
    public String game(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        return "gameBegin";
    }
}
