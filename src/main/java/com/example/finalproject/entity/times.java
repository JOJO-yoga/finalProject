package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(schema = "public",name="times")
public class times {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tid")
    private int tid;

    @Column(name="uid")
    private int uid;
    @Column(name="begin")
    private Timestamp begin;
    @Column(name= "endtime")
    private Timestamp endtime;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }
}
