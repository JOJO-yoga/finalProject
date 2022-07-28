package com.example.finalproject.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="level3")
public class level3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lid")
    private int lid;

    @Column(name="question")
    private String question;
    @Column(name="answer")
    private String answer;
    @Column(name="a")
    private String a;
    @Column(name="b")
    private String b;
    @Column(name="c")
    private String c;
    @Column(name="d")
    private String d;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
