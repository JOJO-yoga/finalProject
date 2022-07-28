package com.example.finalproject.service;

import com.example.finalproject.entity.level1;
import com.example.finalproject.entity.level2;
import org.springframework.data.domain.Page;

import java.util.List;

public interface l2Service  extends java.io.Serializable{
    Page<level2> findLevel2Page(int pageNum, int pageSize);
    level2 findLevel2ByLid(int lid);
    List<level2> findAll();
}
