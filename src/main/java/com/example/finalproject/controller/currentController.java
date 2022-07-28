package com.example.finalproject.controller;

import com.example.finalproject.dao.currentDao;
import com.example.finalproject.dao.userDao;
import com.example.finalproject.entity.current;
import com.example.finalproject.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"current"})
public class currentController {
    @Autowired
    private currentDao currentDao;
    @Autowired
    private com.example.finalproject.dao.userDao userDao;


    @RequestMapping(value={"record"})
    public String record(
            @RequestParam(value ="level")int level,
            @RequestParam(name = "exampleRadios") String answer,
            @RequestParam(value = "lid")Integer lid,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page
    ) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());

        if(currentDao.findCurrentByLevelAndLid(level,lid)==null) {
            current currentInfo = new current();
            currentInfo.setAnswer(answer);
            currentInfo.setLevel(level);
            currentInfo.setLid(lid);
            currentInfo.setUid(userInfo.getId());
            currentDao.save(currentInfo);
        }
        else {
            current currentInfo = currentDao.findCurrentByLevelAndLid(level,lid);
            currentInfo.setAnswer(answer);
            currentInfo.setLevel(level);
            currentInfo.setUid(userInfo.getId());
            currentInfo.setLid(lid);
            currentDao.save(currentInfo);
        }
        if (level==1) {
            return "redirect:/level/begin?pageNum=" + page;
        }
        else if (level==2){
            return "redirect:/level/level2?pageNum=" + page;
        }
        else if (level==3){
            return "redirect:/level/level3?pageNum=" + page;
        }
        else if (level==4){
            return "redirect:/level/level4?pageNum=" + page;
        }
        else if (level==5){
            return "redirect:/level/level5?pageNum=" + page;
        }
        else{
            return "redirect:/level/level6?pageNum=" + page;
        }
    }
}
