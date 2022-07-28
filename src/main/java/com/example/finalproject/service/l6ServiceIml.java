package com.example.finalproject.service;

import com.example.finalproject.entity.level5;
import com.example.finalproject.entity.level6;
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
public class l6ServiceIml implements l6Service{
    @Autowired
    private com.example.finalproject.dao.level6Dao level6Dao;
    @Override
    public Page<level6> findLevel6Page(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level6Dao.findAll(pageable);
    }

    @Override
    public level6 findLevel6ByLid(int lid) {
        return level6Dao.findLevel6ByLid(lid);
    }

    @Override
    public List<level6> findAll() {
        return level6Dao.findAll();
    }
}
