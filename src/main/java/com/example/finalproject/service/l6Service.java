package com.example.finalproject.service;

import com.example.finalproject.entity.level5;
import com.example.finalproject.entity.level6;
import org.springframework.data.domain.Page;

import java.util.List;

public interface l6Service extends java.io.Serializable{
    Page<level6> findLevel6Page(int pageNum, int pageSize);
    level6 findLevel6ByLid(int lid);
    List<level6> findAll();
}
