package com.example.finalproject.service;

import com.example.finalproject.entity.level3;
import com.example.finalproject.entity.level4;
import org.springframework.data.domain.Page;

import java.util.List;

public interface l4Service extends java.io.Serializable{
    Page<level4> findLevel4Page(int pageNum, int pageSize);
    level4 findLevel4ByLid(int lid);
    List<level4> findAll();
}
