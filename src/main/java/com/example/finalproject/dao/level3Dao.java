package com.example.finalproject.dao;

import com.example.finalproject.entity.level2;
import com.example.finalproject.entity.level3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface level3Dao extends JpaRepository<level3, String> {
    public level3 findLevel3ByLid(int lid);
    public List<level3> findAll();
}
