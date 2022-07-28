package com.example.finalproject.service;

import com.example.finalproject.dao.timesDao;
import com.example.finalproject.entity.score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class scoreServiceIml implements scoreService{
    @Autowired
    private com.example.finalproject.dao.scoreDao scoreDao;
    @Override
    public score findScoreBySid(String sid) {
        return scoreDao.findScoreBySid(sid);
    }

    @Override
    public score save(score scoreInfo) {
        return scoreDao.save(scoreInfo);
    }

    @Override
    public List<score> findScoreByLevel(int level) {
        return scoreDao.findScoreByLevel(level);
    }

    @Override
    public List<score> findAll() {
        return scoreDao.findAll() ;
    }

    @Override
    public List<score> findScoreByUid(int uid) {
        return scoreDao.findScoreByUid(uid);
    }

    @Override
    public void deleteScoreBySid(String sid) {
        scoreDao.deleteScoreBySid(sid);
    }
}
