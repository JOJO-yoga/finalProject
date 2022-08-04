package com.example.finalproject.controller;

import com.example.finalproject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping(value={"score"})
public class scoreController {
    @Autowired
    private com.example.finalproject.dao.userDao userDao;
    @Autowired
    private com.example.finalproject.dao.timesDao timesDao;
    @Autowired
    private com.example.finalproject.dao.currentDao currentDao;
    @Autowired
    private com.example.finalproject.dao.scoreDao scoreDao;
    @Autowired
    private com.example.finalproject.dao.level1Dao level1Dao;
    @Autowired
    private com.example.finalproject.dao.level2Dao level2Dao;
    @Autowired
    private com.example.finalproject.dao.level3Dao level3Dao;
    @Autowired
    private com.example.finalproject.dao.level4Dao level4Dao;
    @Autowired
    private com.example.finalproject.dao.level5Dao level5Dao;
    @Autowired
    private com.example.finalproject.dao.level6Dao level6Dao;
    @Autowired
    private com.example.finalproject.dao.recordDao recordDao;
    @RequestMapping(value={"calcuate"})
    public String calcuate(
            @RequestParam(value ="level")int level,
            Model model
    ) throws ParseException {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());

        times timesInfo =timesDao.findTimesByUid(userInfo.getId());
        Date date = new Date();//获得系统时间
        Timestamp ts = new Timestamp(date.getTime());
        timesInfo.setEndtime(ts);
        timesDao.save(timesInfo);
        long timeDiff= (ts.getTime()/(100)-timesInfo.getBegin().getTime()/(100));
        List<current> answers=currentDao.findCurrentByUidAndLevel(userInfo.getId(),level);
        int total=answers.size();
        int right=0;
        switch (level){
            case 1:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level1 l1=level1Dao.findLevel1ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1=new record();
                        record1.setLevel(level);
                        record1.setQuestion(l1.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l1.getA());
                            break;
                        case "b":
                            record1.setAnswer(l1.getB());
                            break;
                        case "c":
                            record1.setAnswer(l1.getC());
                            break;
                        case "d":
                            record1.setAnswer(l1.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l1.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
            case 2:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level2 l2=level2Dao.findLevel2ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1.setLevel(level);
                        record1.setQuestion(l2.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l2.getA());
                            break;
                        case "b":
                            record1.setAnswer(l2.getB());
                            break;
                        case "c":
                            record1.setAnswer(l2.getC());
                            break;
                        case "d":
                            record1.setAnswer(l2.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l2.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
            case 3:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level3 l3=level3Dao.findLevel3ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1.setLevel(level);
                        record1.setQuestion(l3.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l3.getA());
                            break;
                        case "b":
                            record1.setAnswer(l3.getB());
                            break;
                        case "c":
                            record1.setAnswer(l3.getC());
                            break;
                        case "d":
                            record1.setAnswer(l3.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l3.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
            case 4:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level4 l4=level4Dao.findLevel4ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1.setLevel(level);
                        record1.setQuestion(l4.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l4.getA());
                            break;
                        case "b":
                            record1.setAnswer(l4.getB());
                            break;
                        case "c":
                            record1.setAnswer(l4.getC());
                            break;
                        case "d":
                            record1.setAnswer(l4.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l4.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
            case 5:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level5 l5=level5Dao.findLevel5ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1.setLevel(level);
                        record1.setQuestion(l5.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l5.getA());
                            break;
                        case "b":
                            record1.setAnswer(l5.getB());
                            break;
                        case "c":
                            record1.setAnswer(l5.getC());
                            break;
                        case "d":
                            record1.setAnswer(l5.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l5.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
            case 6:
                for(current answer:answers){
                    int lid= answer.getLid();
                    level6 l6=level6Dao.findLevel6ByLid(lid);
                    record record1=recordDao.findRecordByUidAndLevelAndLid(userInfo.getId(), level,lid);
                    if(record1==null){
                        record1.setLevel(level);
                        record1.setQuestion(l6.getQuestion());
                        record1.setUid(userInfo.getId());
                        record1.setLid(lid);
                    }
                    switch (answer.getAnswer()){
                        case "a":
                            record1.setAnswer(l6.getA());
                            break;
                        case "b":
                            record1.setAnswer(l6.getB());
                            break;
                        case "c":
                            record1.setAnswer(l6.getC());
                            break;
                        case "d":
                            record1.setAnswer(l6.getD());
                            break;
                    }
                    record1.setCorrect(0);
                    if (answer.getAnswer().equals(l6.getAnswer())){
                        right+=1;
                        record1.setCorrect(1);
                    }
                    recordDao.save(record1);
                    currentDao.deleteCurrentByCid(answer.getCid());
                }
                break;
        }

        int score=0;
        int totalTime=0;
        score userBest=scoreDao.findScoreBySid(String.valueOf(userInfo.getId())+String.valueOf(level));
        List<score> totalScore=scoreDao.findScoreByLevel(level);
        for(score userScore:totalScore){
            totalTime+=userScore.getTimes();
        }
        int averageTime;
        if (totalScore.size()!=0){
            averageTime=totalTime/totalScore.size();
        }
        else {
            averageTime= (int) timeDiff;
        }

        int timeScore= (int) (averageTime-timeDiff);
        score= (int) ((right*800*right/total)+timeScore);
        if(score>=2400&&(userInfo.getLevel()<level)){
            userInfo.setLevel(level);
            userDao.save(userInfo);
        }
        if (userBest==null){
            userBest =new score();
            String sid=String.valueOf(userInfo.getId())+String.valueOf(level);
            userBest.setSid(sid);
            userBest.setLevel(level);
            userBest.setUid(userInfo.getId());
            userBest.setScore(score);
            userBest.setTimes((int) timeDiff);
        }

        if(score>userBest.getScore()){
            userBest.setScore(score);
            userBest.setTimes((int) timeDiff);
        }

        scoreDao.save(userBest);

        Collections.sort(totalScore);
        int i=1;
        for(score rank:totalScore){
            if(rank.getUid()==userInfo.getId()){
                break;
            }
            else {
                i+=1;
            }
        }

        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("score",score);
        model.addAttribute("time",(timeDiff/10));
        model.addAttribute("accuracy",right);
        model.addAttribute("rank",i);
        model.addAttribute("level",level);
        model.addAttribute("uid",userInfo.getId());
        return "feedback";
    }

    @RequestMapping(value={"rank"})
    public String rank(
            @RequestParam(value ="level")int level,
            Model model
    ){
        List<score> totalScore=scoreDao.findScoreByLevel(level);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        Collections.sort(totalScore);
        Map<Integer,score> map=new HashMap<>();
        for(score i:totalScore){
            map.put(totalScore.indexOf(i)+1,i);
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("level",level);
        model.addAttribute("totalScore",map);
        return "rank";
    }

    @RequestMapping(value={"chart"})
    public String chart(
            Model model
    ){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        user userInfo=userDao.findUserByName(userDetails.getUsername());
        List<score> scores=scoreDao.findScoreByUid(userInfo.getId());
        int userScore1=0,userScore2=0,userScore3=0,userScore4=0,userScore5=0,userScore6=0;
        for(score s:scores){
            switch (s.getLevel()){
                case 1:
                    userScore1=s.getScore();
                    break;
                case 2:
                    userScore2=s.getScore();
                    break;
                case 3:
                    userScore3=s.getScore();
                    break;
                case 4:
                    userScore4=s.getScore();
                    break;
                case 5:
                    userScore5=s.getScore();
                    break;
                case 6:
                    userScore6=s.getScore();
                    break;
            }
        }
        model.addAttribute("loginUser",userDao.findUserByName(userDetails.getUsername()));
        model.addAttribute("userScore1",userScore1);
        model.addAttribute("userScore2",userScore2);
        model.addAttribute("userScore3",userScore3);
        model.addAttribute("userScore4",userScore4);
        model.addAttribute("userScore5",userScore5);
        model.addAttribute("userScore6",userScore6);
        return "chart";
    }
}
