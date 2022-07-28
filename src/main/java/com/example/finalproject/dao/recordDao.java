package com.example.finalproject.dao;


import com.example.finalproject.entity.record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
public interface recordDao extends JpaRepository<record, String> {
    public List<record>  findRecordByUidAndLevel(int uid,int level);
    public record findRecordByRid(int rid);
    public List<record>  findAll();
    public record save(record recordInfo);
    public record findRecordByUidAndLevelAndLid(int uid,int level,int lid);
    @Modifying
    @Transactional
    public void deleteRecordByRid(int rid);
}
