package com.example.finalproject.service;

import com.example.finalproject.entity.level1;
import org.springframework.data.domain.Page;

import java.util.List;

public interface level1Service extends java.io.Serializable{
    Page<level1> findLevel1Page(int pageNum, int pageSize);
    level1 findLevel1ByLid(int lid);
    List<level1> findAll();
}
