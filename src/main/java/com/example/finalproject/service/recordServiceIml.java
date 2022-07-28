package com.example.finalproject.service;

import com.example.finalproject.entity.record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class recordServiceIml implements recordService{
    @Autowired
    private com.example.finalproject.dao.recordDao recordDao;
    @Override
    public List<record> findRecordByUidAndLevel(int uid, int level) {
        return recordDao.findRecordByUidAndLevel(uid,level);
    }

    @Override
    public record findRecordByRid(int rid) {
        return recordDao.findRecordByRid(rid);
    }

    @Override
    public List<record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public record save(record recordInfo) {
        return recordDao.save(recordInfo);
    }

    @Override
    public void deleteRecordByRid(int rid) {
        recordDao.deleteRecordByRid(rid);
    }

    @Override
    public record findRecordByUidAndLevelAndLid(int uid, int level, int lid) {
        return recordDao.findRecordByUidAndLevelAndLid(uid,level,lid);
    }
}
