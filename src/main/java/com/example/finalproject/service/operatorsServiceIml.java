package com.example.finalproject.service;

import com.example.finalproject.dao.operatorsDao;
import com.example.finalproject.entity.operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class operatorsServiceIml implements operatorsService{
    @Autowired
    operatorsDao operatorsDao;
    @Override
    public operators findOperatorsByOid(int oid) {
        return operatorsDao.findOperatorsByOid(oid);
    }

    @Override
    public List<operators> findOperatorsByGid(int gid) {
        return operatorsDao.findOperatorsByGid(gid);
    }

    @Override
    public operators save(operators operatorInfo) {
        return operatorsDao.save(operatorInfo);
    }
}
