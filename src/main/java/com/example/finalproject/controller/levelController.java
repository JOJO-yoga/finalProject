package com.example.finalproject.controller;

import com.example.finalproject.dao.*;
import com.example.finalproject.entity.*;
import com.example.finalproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value={"level"})
public class levelController {

    @Autowired
    private level1Service level1Service;
    @Autowired
    private l2Service l2Service;
    @Autowired
    private l3Service l3Service;
    @Autowired
    private l4Service l4Service;
    @Autowired
    private l5Service l5Service;
    @Autowired
    private l6Service l6Service;
    @Autowired
    private userDao userDao;
    @Autowired
    private timesDao timesDao;
    @Autowired
    private com.example.finalproject.dao.recordDao recordDao;

    @RequestMapping("begin")
    public String login(
            @RequestParam(value ="level",defaultValue = "1")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ) throws ParseException {


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        Page<level1> levels=level1Service.findLevel1Page(page,size);
        model.addAttribute( "levels",levels);

        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }

        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "questions";
    }
    @RequestMapping("level2")
    public String t2(
            @RequestParam(value ="level",defaultValue = "2")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ){
        Page<level2> levels=l2Service.findLevel2Page(page,size);
        model.addAttribute( "levels",levels);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }

        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "question2";
    }

    @RequestMapping("level3")
    public String t3(
            @RequestParam(value ="level",defaultValue = "3")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ){
        Page<level3> levels=l3Service.findLevel3Page(page,size);
        model.addAttribute( "levels",levels);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "question3";
    }

    @RequestMapping("level4")
    public String t4(
            @RequestParam(value ="level",defaultValue = "4")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ){
        Page<level4> levels=l4Service.findLevel4Page(page,size);
        model.addAttribute( "levels",levels);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "question4";
    }

    @RequestMapping("level5")
    public String t5(
            @RequestParam(value ="level",defaultValue = "5")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ){
        Page<level5> levels=l5Service.findLevel5Page(page,size);
        model.addAttribute( "levels",levels);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "question5";
    }
    @RequestMapping("level6")
    public String t6(
            @RequestParam(value ="level",defaultValue = "6")int level,
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "1")Integer size
    ){
        Page<level6> levels=l6Service.findLevel6Page(page,size);
        model.addAttribute( "levels",levels);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        if(userInfo.getLevel()+1<level){
            return "redirect:/level";
        }
        List<record> recordList=recordDao.findRecordByUidAndLevel(userInfo.getId(),level);
        if(recordList!=null){
            for(record record1:recordList){
                recordDao.deleteRecordByRid(record1.getRid());
            }
        }
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());

        if(timesDao.findTimesByUid(userInfo.getId())==null) {
            times timesInfo = new times();
            timesInfo.setUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesDao.save(timesInfo);
        }
        else {
            times timesInfo =timesDao.findTimesByUid(userInfo.getId());
            timesInfo.setBegin(ts);
            timesInfo.setEndtime(null);
            timesDao.save(timesInfo);
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("pageNum",page);
        model.addAttribute("pagetotal",levels.getTotalPages());
        return "question6";
    }
}
