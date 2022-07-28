package com.example.finalproject.dao;

import com.example.finalproject.entity.score;
import com.example.finalproject.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface scoreDao extends JpaRepository<score, String> {
    public score findScoreBySid(String sid);
    public score save(score scoreInfo);
    public List<score> findAll();
    public List<score> findScoreByLevel(int level);
    public List<score> findScoreByUid(int uid);
    @Modifying
    @Transactional
    public void deleteScoreBySid(String sid);
}
