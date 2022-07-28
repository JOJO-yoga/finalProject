package com.example.finalproject.dao;

import com.example.finalproject.entity.level2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface level2Dao extends JpaRepository<level2, String> {
public level2 findLevel2ByLid(int lid);
public List<level2> findAll();
}
