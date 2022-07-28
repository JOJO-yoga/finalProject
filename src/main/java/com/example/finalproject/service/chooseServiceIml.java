package com.example.finalproject.service;

import com.example.finalproject.dao.chooseDao;
import com.example.finalproject.entity.choose;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class chooseServiceIml implements chooseService{
    @Autowired
    chooseDao chooseDao;
    @Override
    public choose findChooseByCid(int cid) {
        return chooseDao.findChooseByCid(cid);
    }

    @Override
    public List<choose> findAll() {
        return chooseDao.findAll();
    }

    @Override
    public List<choose> findChooseByGid(int gid) {
        return chooseDao.findChooseByGid(gid);
    }

    @Override
    public choose save(choose chooseInfo) {
        return chooseDao.save(chooseInfo);
    }

    @Override
    public void deleteChooseByCid(int cid) {
        chooseDao.deleteChooseByCid(cid);
    }
}
