package com.example.finalproject.dao;

import com.example.finalproject.entity.numbers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface numbersDao extends JpaRepository<numbers, String> {
    public List<numbers> findAll();
    public List<numbers> findNumbersByGid(int gid);
    public numbers findNumbersByNid(int nid);
    public numbers save(numbers number);
}
