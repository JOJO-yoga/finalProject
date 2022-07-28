package com.example.finalproject.service;

import com.example.finalproject.entity.score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public interface scoreService {
    public score findScoreBySid(String sid);
    public score save(score scoreInfo);
    public List<score> findScoreByLevel(int level);
    public List<score> findAll();
    public List<score> findScoreByUid(int uid);
    @Modifying
    @Transactional
    public void deleteScoreBySid(String sid);
}
