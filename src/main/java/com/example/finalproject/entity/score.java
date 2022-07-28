package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="score")
public class score implements Comparable<score> {
    @Id
    @Column(name="sid")
    private String sid;

    @Column(name="score")
    private int score;

    @Column(name="times")
    private int times;

    @Column(name="level")
    private int level;

    @Column(name="uid")
    private int uid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public int compareTo(com.example.finalproject.entity.score s1) {
        return s1.getScore()-this.score;
    }
}
