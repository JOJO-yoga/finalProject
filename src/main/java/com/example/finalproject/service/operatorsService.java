package com.example.finalproject.service;

import com.example.finalproject.entity.operators;

import java.util.List;

public interface operatorsService {
    public operators findOperatorsByOid(int oid);
    public List<operators> findOperatorsByGid(int gid);
    public operators save(operators operatorInfo);
}
