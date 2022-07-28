package com.example.finalproject.service;

import com.example.finalproject.dao.gameDao;
import com.example.finalproject.entity.game;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class gameServiceIml implements gameService{
    @Autowired
    private gameDao gameDao;


    @Override
    public game findGameByGid(int gid) {
        return gameDao.findGameByGid(gid);
    }

    @Override
    public List<game> findGameByLevel(int level) {
        return gameDao.findGameByLevel(level);
    }

    @Override
    public List<game> findAll() {
        return gameDao.findAll();
    }

    @Override
    public game save(game gameInfo) {
        return gameDao.save(gameInfo);
    }

    @Override
    public void deleteGameByGid(int gid) {
        gameDao.deleteGameByGid(gid);
    }
}
