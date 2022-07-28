package com.example.finalproject.service;

import com.example.finalproject.entity.choose;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface chooseService {
        public choose findChooseByCid(int cid);
        public List<choose> findAll();
        public List<choose> findChooseByGid(int gid);
        public choose save(choose chooseInfo);
        public void deleteChooseByCid(int cid);
}
