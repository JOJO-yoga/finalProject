package com.example.finalproject.dao;

import com.example.finalproject.entity.times;
import com.example.finalproject.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface timesDao extends JpaRepository<times, String> {
    public times save(times timesInfo);
    public times findTimesByUid(int uid);
    public times findTimesByTid(int tid);
    public List<times> findAll();
}
