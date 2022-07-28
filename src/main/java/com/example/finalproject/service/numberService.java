package com.example.finalproject.service;

import com.example.finalproject.entity.numbers;

import java.util.List;

public interface numberService {
    public List<numbers> findAll();
    public List<numbers> findNumbersByGid(int gid);
    public numbers findNumbersByNid(int nid);
    public numbers save(numbers number);
}
