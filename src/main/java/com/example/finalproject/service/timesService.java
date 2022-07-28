package com.example.finalproject.service;

import com.example.finalproject.entity.times;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface timesService {
    public times save(times timesInfo);
    public times findTimesByUid(int uid);
    public times findTimesByTid(int tid);
    public List<times> findAll();
}
