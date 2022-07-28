package com.example.finalproject.service;

import com.example.finalproject.entity.current;

import java.util.List;

public interface currentService extends java.io.Serializable{
    public List<current> findCurrentByUid(int uid);
    public current findCurrentByLevelAndLid(int level,int lid);
    public current findCurrentByCid(int cid);
    public List<current> findAll();
    public current save(current currentInfo);
    public void deleteCurrentByCid(int cid);
    public List<current> findCurrentByUidAndLevel(int uid,int level);
}
