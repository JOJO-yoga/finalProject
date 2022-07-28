package com.example.finalproject.service;

import com.example.finalproject.dao.currentDao;
import com.example.finalproject.entity.current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class currentServiceIml implements currentService{
    @Autowired
    private currentDao currentDao;

    @Override
    public List<current> findCurrentByUid(int uid) {
        return currentDao.findCurrentByUid(uid);
    }

    @Override
    public current findCurrentByLevelAndLid(int level, int lid) {
        return currentDao.findCurrentByLevelAndLid(level,lid);
    }

    @Override
    public current findCurrentByCid(int cid) {
        return currentDao.findCurrentByCid(cid);
    }

    @Override
    public List<current> findAll() {
        return currentDao.findAll();
    }

    @Override
    public current save(current currentInfo) {
        return currentDao.save(currentInfo);
    }

    @Override
    public void deleteCurrentByCid(int cid) {
        currentDao.deleteCurrentByCid(cid);
    }

    @Override
    public List<current> findCurrentByUidAndLevel(int uid, int level) {
        return currentDao.findCurrentByUidAndLevel(uid,level);
    }
}
