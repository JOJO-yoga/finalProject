package com.example.finalproject.dao;

import com.example.finalproject.entity.game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface gameDao extends JpaRepository<game, String> {
    public game findGameByGid(int gid);
    public List<game> findGameByLevel(int level);
    public List<game> findAll();
    public game save(game gameInfo);
    @Modifying
    @Transactional
    public void deleteGameByGid(int gid);
}
