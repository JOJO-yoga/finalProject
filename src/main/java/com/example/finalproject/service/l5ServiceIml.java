package com.example.finalproject.service;

import com.example.finalproject.entity.level5;
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
public class l5ServiceIml implements l5Service{
    @Autowired
    private com.example.finalproject.dao.level5Dao level5Dao;

    @Override
    public Page<level5> findLevel5Page(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level5Dao.findAll(pageable);
    }

    @Override
    public level5 findLevel5ByLid(int lid) {
        return level5Dao.findLevel5ByLid(lid);
    }

    @Override
    public List<level5> findAll() {
        return level5Dao.findAll();
    }
}
