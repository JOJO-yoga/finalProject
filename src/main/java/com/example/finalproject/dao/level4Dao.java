package com.example.finalproject.dao;


import com.example.finalproject.entity.level4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface level4Dao extends JpaRepository<level4, String> {
    public level4 findLevel4ByLid(int lid);
    public List<level4> findAll();
}
