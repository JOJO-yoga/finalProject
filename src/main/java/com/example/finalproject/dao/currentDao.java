package com.example.finalproject.dao;

import com.example.finalproject.entity.current;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
public interface currentDao extends JpaRepository<current, String> {
    public List<current> findCurrentByUid(int uid);
    public List<current> findCurrentByUidAndLevel(int uid,int level);
    public current findCurrentByLevelAndLid(int level,int lid);
    public current findCurrentByCid(int cid);
    public List<current> findAll();
    public current save(current currentInfo);
    @Modifying
    @Transactional
    public void deleteCurrentByCid(int cid);
}
