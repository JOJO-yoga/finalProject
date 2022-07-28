package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="current")
public class current {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cid")
    private int cid;

    @Column(name="level")
    private int level;
    @Column(name="lid")
    private int lid;
    @Column(name="uid")
    private int uid;
    @Column(name="answer")
    private String answer;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
