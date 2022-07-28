package com.example.finalproject.controller;

import com.example.finalproject.entity.record;
import com.example.finalproject.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value={"record"})
public class detailController {
    @Autowired
    private com.example.finalproject.dao.recordDao recordDao;
    @Autowired
    private com.example.finalproject.dao.userDao userDao;

    @RequestMapping(value={"showDetail"})
    public String showDetail(
            @RequestParam(value ="level")int level,
            @RequestParam(value ="uid")int uid,
            Model model
    ){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo= userDao.findUserByName(userDetails.getUsername());

        List<record> recordList=recordDao.findRecordByUidAndLevel(uid,level);
        model.addAttribute("info",userInfo);
        model.addAttribute("recordList",recordList);
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        return "detail";
    }
}
