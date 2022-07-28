package com.example.finalproject.service;

import com.example.finalproject.entity.level4;
import com.example.finalproject.entity.level5;
import org.springframework.data.domain.Page;

import java.util.List;

public interface l5Service extends java.io.Serializable{
    Page<level5> findLevel5Page(int pageNum, int pageSize);
    level5 findLevel5ByLid(int lid);
    List<level5> findAll();
}
