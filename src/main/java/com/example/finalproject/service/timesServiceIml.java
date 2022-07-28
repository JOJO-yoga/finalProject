package com.example.finalproject.service;

import com.example.finalproject.dao.timesDao;
import com.example.finalproject.entity.times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class timesServiceIml implements timesService{
    @Autowired
    private timesDao timesDao;
    @Override
    public times save(times timesInfo) {
        return timesDao.save(timesInfo);
    }

    @Override
    public times findTimesByUid(int uid) {
        return timesDao.findTimesByUid(uid);
    }

    @Override
    public times findTimesByTid(int tid) {
        return timesDao.findTimesByTid(tid);
    }

    @Override
    public List<times> findAll() {
        return timesDao.findAll();
    }
}
