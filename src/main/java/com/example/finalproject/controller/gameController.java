package com.example.finalproject.controller;

import com.example.finalproject.dao.*;
import com.example.finalproject.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value={"game"})
public class gameController {
    @Autowired
    private gameDao gameDao;
    @Autowired
    private userDao userdao;
    @Autowired
    private operatorsDao operatorsDao;
    @Autowired
    private numbersDao numbersDao;
    @Autowired
    private chooseDao chooseDao;
    @RequestMapping("begin")
    public String gamebegin(
            @RequestParam(value ="level",defaultValue = "1")int level,
            Model model
    ){
        List<game> games=gameDao.findGameByLevel(level);
        Random random = new Random();
        int gid=random.nextInt(games.size());
        if(gid==0){
            gid=1;
        }
        game g1=gameDao.findGameByGid(gid);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        List<numbers> numbers=numbersDao.findNumbersByGid(gid);
        List<operators> operatorsList= operatorsDao.findOperatorsByGid(gid);
        Collections.sort(operatorsList);
        String[]question =  new String[g1.getRestrain()+operatorsList.size()];
        int i=0;
        for (operators operators1:operatorsList){
            question[i]="?";
            question[i+1]=operators1.getTypes();
            i=i+2;
        }
        question[i]="?";
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        model.addAttribute("gid",gid);
        model.addAttribute("limit",g1.getCurrent());
        model.addAttribute("numbers",numbers);
        model.addAttribute("question",question);
        return "showQuestion";
    }


    @RequestMapping("fill")
    public String gamebegin(
            @RequestParam(value ="choice")int nid,
            @RequestParam(value ="gid")int gid
    ){
        game game1=gameDao.findGameByGid(gid);
        int currentFill=game1.getCurrent()+1;
        numbers number=numbersDao.findNumbersByNid(nid);
        choose choose1=new choose();

        game1.setCurrent(currentFill);
        gameDao.save(game1);
        choose1.setFigure(number.getFigure());
        choose1.setGid(gid);
        choose1.setPosition(currentFill);
        choose1.setNid(nid);
        chooseDao.save(choose1);
        number.setStatus(1);
        numbersDao.save(number);
        if(currentFill>=game1.getRestrain()){
            return "redirect:/game/answer?gid="+String.valueOf(gid);
        }
        return "redirect:/game/select?gid="+String.valueOf(gid);
    }

    @RequestMapping("select")
    public String select(
            @RequestParam(value ="gid")int gid,
            Model model
    ){
        game g2=gameDao.findGameByGid(gid);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        List<numbers> numberTotal=numbersDao.findNumbersByGid(gid);
        List<numbers> numbers=numbersDao.findNumbersByGid(gid);
        for(numbers n:numberTotal){
            if(n.getStatus()==1){
                numbers.remove(n);
            }
        }
        List<operators> operatorsList= operatorsDao.findOperatorsByGid(gid);
        List<choose> chooses=chooseDao.findChooseByGid(gid);

        Collections.sort(chooses);
        Collections.sort(operatorsList);
        String[]question =  new String[g2.getRestrain()+operatorsList.size()];
        int i;
        for (i=0;i<chooses.size();i=i+1){;
            question[2*i]=String.valueOf(chooses.get(i).getFigure());
            question[2*i+1]=operatorsList.get(i).getTypes();
        }
        int j;

            for (j = i; j < operatorsList.size(); j = j + 1) {
                question[2 * j] = "?";
                question[2 * j + 1] = operatorsList.get(j).getTypes();
            }

            j=i;

        question[2*j]="?";

        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        model.addAttribute("gid",gid);
        model.addAttribute("limit",g2.getCurrent()+1);
        model.addAttribute("numbers",numbers);
        model.addAttribute("question",question);
        return "showQuestion";
    }

    @RequestMapping("answer")
    public String answer(
            @RequestParam(value ="gid")int gid,
            Model model
    ){
        game g2=gameDao.findGameByGid(gid);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        List<numbers> numberTotal=numbersDao.findNumbersByGid(gid);
        List<numbers> numbers=numbersDao.findNumbersByGid(gid);
        for(numbers n:numberTotal){
            if(n.getStatus()==1){
                numbers.remove(n);
            }
        }

        List<operators> operatorsList= operatorsDao.findOperatorsByGid(gid);
        List<choose> chooses=chooseDao.findChooseByGid(gid);

        Collections.sort(chooses);
        Collections.sort(operatorsList);
        String[]question =  new String[g2.getRestrain()+operatorsList.size()];
        int i;
        for (i=0;i<chooses.size();i=i+1){;
            question[2*i]=String.valueOf(chooses.get(i).getFigure());
            if(i<(operatorsList.size())) {
                question[2 * i + 1] = operatorsList.get(i).getTypes();
            }
        }

        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        model.addAttribute("gid",gid);
        model.addAttribute("limit",g2.getCurrent()+1);
        model.addAttribute("numbers",numbers);
        model.addAttribute("question",question);

        return "judge";

    }

    @RequestMapping("end")
    public String end(
            @RequestParam(value ="gid")int gid,
            Model model,
            @RequestParam(value ="solve")String solve
    ) throws ScriptException {
        game g3=gameDao.findGameByGid(gid);
        List<numbers> numberTotal=numbersDao.findNumbersByGid(gid);
        List<numbers> numbers=numbersDao.findNumbersByGid(gid);
        for(numbers n:numberTotal){
            if(n.getStatus()==1){
                numbers.remove(n);
            }
        }

        int answer=Integer.parseInt(solve);
        List<operators> operatorsList= operatorsDao.findOperatorsByGid(gid);
        List<choose> chooses=chooseDao.findChooseByGid(gid);

        Collections.sort(chooses);
        Collections.sort(operatorsList);
        String question =  "";
        int i;
        for (i=0;i<chooses.size();i=i+1){;
            question =question+String.valueOf(chooses.get(i).getFigure());
            if(i<(operatorsList.size())) {
                question =question+ operatorsList.get(i).getTypes();
            }
        }
        int solution;
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        solution= (int) jse.eval(question);

        game newgame=gameDao.findGameByGid(gid);
        newgame.setCurrent(0);
        gameDao.save(newgame);
        for (choose c1:chooses){
            chooseDao.deleteChooseByCid(c1.getCid());
        }

        if(solution==answer && g3.getRestrain()<=numbers.size()){
            newgame.setCurrent(0);
            gameDao.save(newgame);
            return "redirect:/game/select?gid="+String.valueOf(gid);
        }

        for(numbers n:numberTotal){
            if(n.getStatus()==1){
                numbers n1=numbersDao.findNumbersByNid(n.getNid());
                n1.setStatus(0);
                numbersDao.save(n1);
            }
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("level",newgame.getLevel());
        model.addAttribute("gid",gid);
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        if(solution!=answer){
            return "lose";
        }
        return "sucess";
    }

    @RequestMapping("hold")
    public String hold(
            @RequestParam(value ="gid")int gid,
            Model model
    ) throws ScriptException {
        game g4=gameDao.findGameByGid(gid);
        List<numbers> numberTotal=numbersDao.findNumbersByGid(gid);
        List<choose> chooses=chooseDao.findAll();
        List<operators> operatorsList= operatorsDao.findOperatorsByGid(gid);
        String question =  "";

        int i;
        for (i=0;i<chooses.size();i=i+1){;
            question =question+String.valueOf(chooses.get(i).getFigure());
            if(i<(operatorsList.size())) {
                question =question+ operatorsList.get(i).getTypes();
            }
        }
        int solution;
        int judge=0;
        ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
        try{
            solution= (int) jse.eval(question);
        }catch (Exception e){
            judge=1;
        }

        for (choose c1:chooses){
            chooseDao.deleteChooseByCid(c1.getCid());
        }
        for(numbers n:numberTotal){
            if(n.getStatus()==1){
                numbers n1=numbersDao.findNumbersByNid(n.getNid());
                n1.setStatus(0);
                numbersDao.save(n1);
            }
        }
        g4.setCurrent(0);
        gameDao.save(g4);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("level",g4.getLevel());
        model.addAttribute("gid",gid);
        model.addAttribute("loginUser",userdao.findUserByName(userDetails.getUsername()));
        if(judge==1){
            return "sucess";
        }
        return "lose";
    }
}
