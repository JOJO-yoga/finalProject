package com.example.finalproject.service;

import com.example.finalproject.entity.game;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface gameService {
    public game findGameByGid(int gid);
    public List<game> findGameByLevel(int level);
    public List<game> findAll();
    public game save(game gameInfo);
    public void deleteGameByGid(int gid);
}
