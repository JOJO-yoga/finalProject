package com.example.finalproject.service;

import com.example.finalproject.dao.level1Dao;
import com.example.finalproject.entity.level2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class l2ServiceIml implements l2Service{

    @Autowired
    private com.example.finalproject.dao.level2Dao level2Dao;
    @Override
    public Page<level2> findLevel2Page(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level2Dao.findAll(pageable);
    }

    @Override
    public level2 findLevel2ByLid(int lid) {
        return level2Dao.findLevel2ByLid(lid);
    }

    @Override
    public List<level2> findAll() {
        return level2Dao.findAll();
    }
}
