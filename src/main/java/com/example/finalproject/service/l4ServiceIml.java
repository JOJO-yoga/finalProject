package com.example.finalproject.service;

import com.example.finalproject.entity.level4;
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
public class l4ServiceIml implements l4Service{
    @Autowired
    private com.example.finalproject.dao.level4Dao level4Dao;
    @Override
    public Page<level4> findLevel4Page(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.ASC,"lid");
        return level4Dao.findAll(pageable);
    }

    @Override
    public level4 findLevel4ByLid(int lid) {
        return level4Dao.findLevel4ByLid(lid);
    }

    @Override
    public List<level4> findAll() {
        return level4Dao.findAll();
    }
}
