package com.example.finalproject.service;

import com.example.finalproject.dao.level1Dao;
import com.example.finalproject.entity.level1;
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
public class level1ServiceIml implements level1Service{
    @Autowired
    private level1Dao level1Dao;
    @Override
    public Page<level1> findLevel1Page(int pageNum, int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level1Dao.findAll(pageable);
    }

    @Override
    public level1 findLevel1ByLid(int lid) {
        return level1Dao.findLevel1ByLid(lid);
    }

    @Override
    public List<level1> findAll() {
        return level1Dao.findAll();
    }
}
