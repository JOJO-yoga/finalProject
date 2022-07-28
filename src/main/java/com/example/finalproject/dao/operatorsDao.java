package com.example.finalproject.dao;

import com.example.finalproject.entity.operators;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface operatorsDao  extends JpaRepository<operators, String> {
    public operators findOperatorsByOid(int oid);
    public List<operators> findOperatorsByGid(int gid);
    public operators save(operators operatorInfo);

}
