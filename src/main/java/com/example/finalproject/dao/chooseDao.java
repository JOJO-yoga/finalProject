package com.example.finalproject.dao;

import com.example.finalproject.entity.choose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface chooseDao extends JpaRepository<choose, String> {
    public choose findChooseByCid(int cid);
    public List<choose> findAll();
    public List<choose> findChooseByGid(int gid);
    public choose save(choose chooseInfo);
    @Modifying
    @Transactional
    public void deleteChooseByCid(int cid);
}
