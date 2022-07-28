package com.example.finalproject.dao;


import com.example.finalproject.entity.level5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface level5Dao extends JpaRepository<level5, String> {
    public level5 findLevel5ByLid(int lid);
    public List<level5> findAll();
}
