package com.example.finalproject.service;

import com.example.finalproject.entity.level2;
import com.example.finalproject.entity.level3;
import org.springframework.data.domain.Page;

import java.util.List;

public interface l3Service extends java.io.Serializable{
    Page<level3> findLevel3Page(int pageNum, int pageSize);
    level3 findLevel3ByLid(int lid);
    List<level3> findAll();
}
