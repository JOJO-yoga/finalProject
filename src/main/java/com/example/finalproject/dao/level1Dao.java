package com.example.finalproject.dao;

import com.example.finalproject.entity.level1;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface level1Dao extends JpaRepository<level1, String> {
    public level1 findLevel1ByLid(int lid);
    public List<level1> findAll();
}
