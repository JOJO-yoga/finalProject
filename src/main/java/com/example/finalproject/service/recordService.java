package com.example.finalproject.service;

import com.example.finalproject.entity.record;;
import java.util.List;

public interface recordService {
    public List<record> findRecordByUidAndLevel(int uid, int level);
    public record findRecordByRid(int rid);
    public List<record>  findAll();
    public record save(record recordInfo);
    public void deleteRecordByRid(int rid);
    public record findRecordByUidAndLevelAndLid(int uid,int level,int lid);
}
