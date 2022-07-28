package com.example.finalproject.service;

import com.example.finalproject.dao.level1Dao;
import com.example.finalproject.entity.numbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class numberServiceIml implements numberService{
    @Autowired
    private com.example.finalproject.dao.numbersDao numbersDao;
    @Override
    public List<numbers> findAll() {
        return numbersDao.findAll();
    }

    @Override
    public List<numbers> findNumbersByGid(int gid) {
        return numbersDao.findNumbersByGid(gid);
    }

    @Override
    public numbers findNumbersByNid(int nid) {
        return numbersDao.findNumbersByNid(nid);
    }

    @Override
    public numbers save(numbers number) {
        return numbersDao.save(number);
    }
}
