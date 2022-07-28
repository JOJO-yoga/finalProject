package com.example.finalproject.dao;


import com.example.finalproject.entity.level6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface level6Dao extends JpaRepository<level6, String> {
    public level6 findLevel6ByLid(int lid);
    public List<level6> findAll();
}
