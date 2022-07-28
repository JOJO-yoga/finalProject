package com.example.finalproject.service;

import com.example.finalproject.entity.level3;
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
public class l3ServcieIml implements l3Service{
    @Autowired
    private com.example.finalproject.dao.level3Dao level3Dao;
    @Override
    public Page<level3> findLevel3Page(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level3Dao.findAll(pageable);
    }

    @Override
    public level3 findLevel3ByLid(int lid) {
        return level3Dao.findLevel3ByLid(lid);
    }

    @Override
    public List<level3> findAll() {
        return level3Dao.findAll();
    }
}
